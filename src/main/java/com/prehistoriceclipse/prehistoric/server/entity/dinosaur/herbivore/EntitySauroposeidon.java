package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore;

import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDinoMate;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIHerd;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntitySpinosaurus;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityTyrannosaurusRex;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySauroposeidon extends EntityHerbivore {

    public EntitySauroposeidon(World world) {
        super(world);
        this.setSize(5F, 8F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAIHerd(this));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 15.0F));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTyrannosaurusRex.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntitySpinosaurus.class, 30.0F, 1.5D));
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.18D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(13.0D);
    }

    @Override
    public EntitySauroposeidon createChild(EntityAgeable ageable) {
        return new EntitySauroposeidon(this.world);
    }

    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(Reference.MOD_ID + ":models/entity/saur/male.png");
    }
    @Override
    public ResourceLocation getVariantTexture(){
        return new ResourceLocation(Reference.MOD_ID, "models/entity/saur/female.png");
    }
    
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 6;
    }
}
