package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore;

import com.google.common.base.Predicate;
import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDinoMate;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAICall;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIEat;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIStartle;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.EntityDinosaur;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityPachycephalosaurus;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityPlateosaurus;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityProtoceratops;
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

public class EntityCeratosaurus extends EntityCarnivore{

    public EntityCeratosaurus(World worldIn)
    {
        super(worldIn);
        this.setSize(2.0F, 2.5F);
    }
    @Override
    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTyrannosaurusRex.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntitySpinosaurus.class, 30.0F, 1.5D)); 
        this.aiCall = new EntityAICall(this);
        this.aiEat = new EntityAIEat(this);
        this.aiStartle = new EntityAIStartle(this);
        this.tasks.addTask(2, this.aiEat);
        this.tasks.addTask(3, this.aiCall);
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
        this.tasks.addTask(8, this.aiStartle);
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 25.0F));
        this.targetTasks.addTask(5, new EntityAITargetNonTamed(this, EntityDinosaur.class, true, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity entity) {
                return entity instanceof EntityDakotaraptor || entity instanceof EntityMonolophosaurus || entity instanceof EntityPlateosaurus || entity instanceof EntityPig || entity instanceof EntitySheep || entity instanceof EntityCow || entity instanceof EntityProtoceratops || entity instanceof EntityTitanoceratops || entity instanceof EntityPachycephalosaurus;
            }
        }));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(39.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
    }
    @Override
    public EntityCeratosaurus createChild(EntityAgeable entity){
        return new EntityCeratosaurus(this.world);
    }
    public void applyEntityAttributesBonus()
    {
        if (this.isChild())
        {
        	super.applyEntityAttributes();
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.149D);
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
            this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
        }
    }

    @Override
    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID + ":models/entity/cerato/male.png");
    }
    @Override
    public ResourceLocation getVariantTexture(){
        return new ResourceLocation(Reference.MOD_ID + ":models/entity/cerato/female.png");
    }
    
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 5;
    }
}