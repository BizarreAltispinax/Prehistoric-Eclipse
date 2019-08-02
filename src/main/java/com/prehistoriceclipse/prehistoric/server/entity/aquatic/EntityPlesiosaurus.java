package com.prehistoriceclipse.prehistoric.server.entity.aquatic;

import com.google.common.base.Predicate;
import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAIHerd;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAITargetWater;
import com.prehistoriceclipse.prehistoric.server.handler.SoundHandler;
import com.prehistoriceclipse.prehistoric.server.init.PEItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityPlesiosaurus extends EntityAquatic {

    public EntityPlesiosaurus(World worldIn)
    {
        super(worldIn);
        this.setSize(2.0F, 1F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAIHerd(this));
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, false));
        this.targetTasks.addTask(0, new EntityAITargetWater(this, EntityLivingBase.class, true, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity p_apply_1_) { return p_apply_1_ instanceof EntitySaurichthys; }})
        );
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(26.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return super.attackEntityFrom(source, amount);
    }

    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID, "models/entity/ples/male.png");
    }

    public ResourceLocation getVariantTexture(){
        return new ResourceLocation(Reference.MOD_ID, "models/entity/ples/female.png");
    }
    @Override
    public EntityPlesiosaurus createChild(EntityAgeable entity){
        return new EntityPlesiosaurus(this.world);
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource souce) {

        return SoundHandler.PLESIOSAURUS_HURT;

    }
    
	@Override
	  protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier){
		  this.dropItem(PEItems.PLESIOSAURUS_MEAT, 1);
	    }
	
	public boolean doesFlock() {
		return true;
	}
	
    public int getMaxSpawnedInChunk() {
        return 7;
    }
}