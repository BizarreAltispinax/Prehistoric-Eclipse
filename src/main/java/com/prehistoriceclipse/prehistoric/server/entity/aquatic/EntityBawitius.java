package com.prehistoriceclipse.prehistoric.server.entity.aquatic;

import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityTyrannosaurusRex;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityBawitius extends EntityAquatic {

    public EntityBawitius(World worldIn){
        super(worldIn);
        this.setSize(0.5F, 0.5F);
    }
   @Override
   protected void initEntityAI(){
       super.initEntityAI();
       this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityDunkleosteus.class, 30.0F, 0.8D));
       this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityMawsonia.class, 30.0F, 0.8D));
       this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityPlesiosaurus.class, 30.0F, 0.8D));
       this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityAmmonite.class, 30.0F, 0.8D));
       this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntitySeaScorpion.class, 30.0F, 0.8D));
   }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.38D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return super.attackEntityFrom(source, amount);
    }

    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID, "models/entity/baw/bawitiusm.png");
    }
    @Override
    public EntityBawitius createChild(EntityAgeable entity){
        return new EntityBawitius(this.world);
    }
    
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 10;
    }
}