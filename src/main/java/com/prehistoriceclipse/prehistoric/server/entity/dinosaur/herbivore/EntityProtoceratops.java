package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore;

import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.*;
import com.prehistoriceclipse.prehistoric.server.entity.ai.*;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.*;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityProtoceratops extends EntityHerbivore{

    public EntityProtoceratops(World world){
        super(world);
        this.setSize(1.5F, 1F);
    }

    @Override
    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAIHerd(this));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityVelociraptor.class, 15.0F));
        this.tasks.addTask(3, new EntityAIDefense(this, 6.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityVelociraptor.class, true));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityDakotaraptor.class, 40.0F, 2.0D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityMonolophosaurus.class, 40.0F, 2.0D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTyrannosaurusRex.class, 40.0F, 2.0D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityAllosaurus.class, 40.0F, 2.0D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityCeratosaurus.class, 40.0F, 2.0D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntitySpinosaurus.class, 40.0F, 2.0D));
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(26.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.5D);
    }

    @Override
    public EntityProtoceratops createChild(EntityAgeable ageable){
        return new EntityProtoceratops(this.world);
    }

    @Override
    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID, "models/entity/proto/male.png");
    }
    @Override
    public ResourceLocation getVariantTexture(){
        return new ResourceLocation(Reference.MOD_ID, "models/entity/proto/female.png");
    }
    
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 6;
    }
}