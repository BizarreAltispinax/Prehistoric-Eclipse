package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore;

import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDefense;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDinoMate;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIHerd;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.*;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityTherizinosaurus extends EntityHerbivore {

    public EntityTherizinosaurus(World world) {
        super(world);
        this.setTamed(true);
        this.setSize(2.9F, 4.0F);
        this.tasks.addTask(0, new EntityAIHerd(this));
        this.tasks.addTask(3, new EntityAIDefense(this, 6.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityTyrannosaurusRex.class, true));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityAllosaurus.class, true));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityCeratosaurus.class, true));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityDakotaraptor.class, true));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityMonolophosaurus.class, true));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntitySpinosaurus.class, true));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityVelociraptor.class, true));
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(42.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(13.0D);
    }

    @Override
    public EntityTherizinosaurus createChild(EntityAgeable ageable) {
        return new EntityTherizinosaurus(this.world);
    }

    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(Reference.MOD_ID, "models/entity/theri/male.png");
    }
    
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 5;
    }
}