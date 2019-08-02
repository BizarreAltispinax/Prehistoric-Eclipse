package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore;


import com.google.common.base.Predicate;
import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDinoMate;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAICall;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIEat;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIStartle;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityPlateosaurus;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityTitanoceratops;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
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

public class EntityMonolophosaurus extends EntityCarnivore {

    public EntityMonolophosaurus(World world){
        super(world);
        this.setSize(2.0F, 1.8F);
    }
    @Override
    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTyrannosaurusRex.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntitySpinosaurus.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityAllosaurus.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityCeratosaurus.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTitanoceratops.class, 30.0F, 1.5D));
        this.aiCall = new EntityAICall(this);
        this.aiEat = new EntityAIEat(this);
        this.aiStartle = new EntityAIStartle(this);
        this.tasks.addTask(2, this.aiEat);
        this.tasks.addTask(2, this.aiCall);
        this.tasks.addTask(5, this.aiStartle);
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 20.0F));
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
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(32.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
    }
    @Override
    public void onLivingUpdate() {
        if (this.getCustomNameTag().equals("Sanic")) {
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(2.0D);
        }
        super.onLivingUpdate();
    }
    @Override
    public EntityMonolophosaurus createChild(EntityAgeable entity){
        return new EntityMonolophosaurus(this.world);
    }
    public void applyEntityAttributesBonus()
    {
        if (this.isChild())
        {
        	super.applyEntityAttributes();
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.9D);
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(13.0D);
            this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.5D);
        }
    }
    @Override
    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID, "models/entity/mono/male.png");
    }
    @Override
    public ResourceLocation getVariantTexture(){
        return new ResourceLocation(Reference.MOD_ID,"models/entity/mono/female.png");
    }
    
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 6;
    }
}
