package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore;

import com.google.common.base.Predicate;
import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDinoMate;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIHerd;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAICall;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIEat;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIStartle;
import com.prehistoriceclipse.prehistoric.server.entity.aquatic.EntityAquatic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityAllosaurus extends EntityCarnivore{

    public EntityAllosaurus(World worldIn)
    {
        super(worldIn);
        this.setSize(2.0F, 2.0F);
        this.setTamed(false);
    }
    @Override
    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAIHerd(this));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTyrannosaurusRex.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntitySpinosaurus.class, 30.0F, 1.5D)); 
        this.aiCall = new EntityAICall(this);
        this.aiEat = new EntityAIEat(this);
        this.aiStartle = new EntityAIStartle(this);
        this.tasks.addTask(2, this.aiEat);
        this.tasks.addTask(3, this.aiCall);
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
        this.tasks.addTask(8, this.aiStartle);
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 18.0F));
        this.targetTasks.addTask(5, new EntityAITargetNonTamed(this, EntityLiving.class, true, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity entity) {
                return !(entity instanceof EntityAquatic) && !(entity instanceof EntityAllosaurus || entity instanceof EntityPig || entity instanceof EntitySheep || entity instanceof EntityCow);
            }
        }));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(37.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(11.0D);
    }
    @Override
    public EntityAllosaurus createChild(EntityAgeable ageable)
    {
        return new EntityAllosaurus(this.world);
    }
    public void applyEntityAttributesBonus()
    {
        if (this.isChild())
        {
        	super.applyEntityAttributes();
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(17.0D);
            this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        }
    }
    @Override
    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID + ":models/entity/allo/male.png");
    }
    @Override
    public ResourceLocation getVariantTexture(){
        return new ResourceLocation(Reference.MOD_ID + ":models/entity/allo/female.png");
    }
    
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 6;
    }
}