package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore;

import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDefense;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDinoMate;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.*;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityPlateosaurus extends EntityHerbivore{

    public EntityPlateosaurus(World world){
        super(world);
        this.setSize(2.0F, 2.0F);
    }

    @Override
    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityCeratosaurus.class, 15.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityCeratosaurus.class, true));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityDakotaraptor.class, 15.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityDakotaraptor.class, true));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityMonolophosaurus.class, 15.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityMonolophosaurus.class, true));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityVelociraptor.class, 15.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityVelociraptor.class, true));
        this.tasks.addTask(3, new EntityAIDefense(this, 6.0F));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTyrannosaurusRex.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityAllosaurus.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntitySpinosaurus.class, 30.0F, 1.5D));
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.36D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
    }

    @Override
    public EntityPlateosaurus createChild(EntityAgeable ageable){
        return new EntityPlateosaurus(this.world);
    }

    @Override
    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID, "models/entity/plateo/male.png");
    }
    @Override
    public ResourceLocation getVariantTexture(){
        return new ResourceLocation(Reference.MOD_ID, "models/entity/plateo/female.png");
    }
    
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 7;
    }
}