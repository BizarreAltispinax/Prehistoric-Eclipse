package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore;

import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDefense;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDinoMate;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIHerd;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityAllosaurus;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityCeratosaurus;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityDakotaraptor;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityMonolophosaurus;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityTyrannosaurusRex;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityVelociraptor;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityPachycephalosaurus extends EntityHerbivore {

    public EntityPachycephalosaurus(World world) {
        super(world);
        this.setTamed(true);
        this.setSize(1.5F, 1.5F);

    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAIHerd(this));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityVelociraptor.class, 15.0F));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityDakotaraptor.class, 15.0F));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityMonolophosaurus.class, 15.0F));
        this.tasks.addTask(3, new EntityAIDefense(this, 6.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityVelociraptor.class, true));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityDakotaraptor.class, true));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityMonolophosaurus.class, true));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityCeratosaurus.class, 20.0F, 0.6D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityAllosaurus.class, 20.0F, 0.6D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTyrannosaurusRex.class, 20.0F, 0.6D));
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(29.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.36D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
    }

    @Override
    public EntityPachycephalosaurus createChild(EntityAgeable ageable) {
        return new EntityPachycephalosaurus(this.world);
    }

    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(Reference.MOD_ID, "models/entity/pachy/male.png");
    }

    @Override
    public ResourceLocation getVariantTexture() {
        return new ResourceLocation(Reference.MOD_ID, "models/entity/pachy/female.png");
    }
    
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 5;
    }
}