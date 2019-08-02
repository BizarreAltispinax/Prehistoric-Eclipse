package com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore;

import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDefense;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIDinoMate;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIHerd;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityCarnivore;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntitySpinosaurus;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityTyrannosaurusRex;
import com.prehistoriceclipse.prehistoric.server.init.PEItems;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityTitanoceratops extends EntityHerbivore{

    public EntityTitanoceratops(World world){
        super(world);
        this.setSize(3.0F, 4.0F);
    }

    @Override
    protected void initEntityAI()
    {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAIHerd(this));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 15.0F));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityCarnivore.class, 15.0F));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityTyrannosaurusRex.class, 30.0F, 1.5D));
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntitySpinosaurus.class, 30.0F, 1.5D)); 
        this.tasks.addTask(3, new EntityAIDefense(this, 8.0F));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityCarnivore.class, true));
        this.tasks.addTask(7, new EntityAIDinoMate(this, 1.0D));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(36.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(11.0D);
    }

    @Override
    public EntityTitanoceratops createChild(EntityAgeable ageable){
        return new EntityTitanoceratops(this.world);
    }

    @Override
    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID + ":models/entity/titan/titanoceratops.png");
    }
    
	@Override
	  protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier){
		  this.dropItem(PEItems.TITANOCERATOPS_MEAT, 1);
	    }
	
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 10;
    }
}
