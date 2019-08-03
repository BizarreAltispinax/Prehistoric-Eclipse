package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore;

import com.google.common.base.Predicate;
import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDinoMate;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIHerd;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIEat;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIStartle;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityPachycephalosaurus;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityPlateosaurus;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityProtoceratops;
import com.prehistoriceclipse.prehistoric.server.init.PEItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityVelociraptor extends EntityCarnivore {

    public EntityVelociraptor(World world){
        super(world);
        this.setSize(1F, 1F);
    }
    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAIHerd(this));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTyrannosaurusRex.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityAllosaurus.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntitySpinosaurus.class, 30.0F, 1.5D));       
        this.aiStartle = new EntityAIStartle(this);
        this.aiEat = new EntityAIEat(this);
        this.tasks.addTask(4, new EntityAIDinoMate(this, 1.0D));
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
        this.tasks.addTask(2, this.aiEat);
        this.tasks.addTask(5, this.aiStartle);
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 15.0F));
        this.targetTasks.addTask(5, new EntityAITargetNonTamed(this, EntityProtoceratops.class, true, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity entity) {return entity instanceof EntityProtoceratops || entity instanceof EntityPlateosaurus || entity instanceof EntityPachycephalosaurus;
            }
        }));
        super.initEntityAI();
    }
    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }
    @Override
    public boolean isMoving() {
        return limbSwingAmount > 0.02F;
    }
    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
    }
    @Override
    public EntityVelociraptor createChild(EntityAgeable entity){
        return new EntityVelociraptor(this.world);
    }
    public void applyEntityAttributesBonus()
    {
        if (this.isChild())
        {
        	super.applyEntityAttributes();
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
            this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
        }
    }
    @Override
    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID ,"models/entity/velo/velociraptor.png");
    }
    
	@Override
	  protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier){
		  this.dropItem(PEItems.VELOCIRAPTOR_MEAT, 1);
	    }
	
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 6;
    }

    @Override
    public float getFallResistance() {
        return 100;
    }

    @Override
    public double getFallingMod() {
        return 0.9D;
    }
}
