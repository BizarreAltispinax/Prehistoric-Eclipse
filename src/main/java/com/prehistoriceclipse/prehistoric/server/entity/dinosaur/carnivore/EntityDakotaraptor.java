package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDinoMate;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIHerd;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAICall;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIEat;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIStartle;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityPlateosaurus;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityTitanoceratops;
import com.prehistoriceclipse.prehistoric.server.handler.SoundHandler;
import com.prehistoriceclipse.prehistoric.server.init.PEItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityDakotaraptor extends EntityCarnivore{
	
    private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntityDakotaraptor.class, DataSerializers.BYTE);
    public EntityDakotaraptor(World worldIn)
    {        
        super(worldIn);
        this.setSize(1.4F, 1.4F);
    }
    @Override
    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAIHerd(this));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTyrannosaurusRex.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntitySpinosaurus.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityAllosaurus.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityCeratosaurus.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTitanoceratops.class, 30.0F, 1.5D));
        this.aiCall = new EntityAICall(this);
        this.aiEat = new EntityAIEat(this);
        this.aiStartle = new EntityAIStartle(this);
        this.tasks.addTask(2, this.aiEat);
        this.tasks.addTask(3, this.aiCall);
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
        this.tasks.addTask(8, this.aiStartle);
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 25.0F));
        this.targetTasks.addTask(5, new EntityAITargetNonTamed(this, EntityPlateosaurus.class, true, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity entity) {
                return entity instanceof EntityPlateosaurus || entity instanceof EntityPig || entity instanceof EntitySheep || entity instanceof EntityCow;
            }
        }));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        //run speed = 0.38
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.35D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
    }
    
    @Override
    public EntityDakotaraptor createChild(EntityAgeable ageable)
    {
        return new EntityDakotaraptor(this.world);
    }
    public void applyEntityAttributesBonus()
    {
        if (this.isChild())
        {
        	super.applyEntityAttributes();
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
            this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.5D);
        }
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource souce) {

        return SoundHandler.DAKORAPTOR_HURT;

    }

    @Override
    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID + ":models/entity/dako/dakotaraptor.png");
    }
    
	@Override
	  protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier){
		  this.dropItem(PEItems.DAKOTARAPTOR_SKULL, 1);
		  this.dropItem(PEItems.DAKOTARAPTOR_MEAT, 2);
		  this.dropItem(PEItems.DAKOTARAPTOR_FEATHER, 20);
		  this.dropItem(PEItems.DAKOTARAPTOR_CLAW, 2);
	    }
	
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 7;
    }
    
	 public double getMountedYOffset()
	    {
	        return (double)(this.height * 0.5F);
	    }
	    protected PathNavigate createNavigator(World worldIn)
	    {
	        return new PathNavigateClimber(this, worldIn);
	    }

	    protected void entityInit()
	    {
	        super.entityInit();
	        this.dataManager.register(CLIMBING, Byte.valueOf((byte)0));
	    }
	
	    public boolean isOnLadder()
	    {
	        return this.isBesideClimbableBlock();
	    }
	    
	    public boolean isBesideClimbableBlock()
	    {
	        return (((Byte)this.dataManager.get(CLIMBING)).byteValue() & 1) != 0;
	    }
	    
	    public void setInWeb()
	    {
	    }

	    public void setBesideClimbableBlock(boolean climbing)
	    {
	        byte b0 = ((Byte)this.dataManager.get(CLIMBING)).byteValue();

	        if (climbing)
	        {
	            b0 = (byte)(b0 | 1);
	        }
	        else
	        {
	            b0 = (byte)(b0 & -2);
	        }

	        this.dataManager.set(CLIMBING, Byte.valueOf(b0));
	    }
	    
	    public EnumCreatureAttribute getCreatureAttribute()
	    {
	        return EnumCreatureAttribute.ARTHROPOD;
	    }
}
