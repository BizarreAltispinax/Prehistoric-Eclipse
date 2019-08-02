package com.prehistoriceclipse.prehistoric.server.entity.aquatic;

import com.google.common.base.Predicate;
import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAITargetWater;
import com.prehistoriceclipse.prehistoric.server.entity.ai.animation.EntityAIRunFromEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntitySeaScorpion extends EntityAquatic {

    public EntitySeaScorpion(World worldIn)
    {
        super(worldIn);
        this.setSize(1.5F, 0.6F);
    }
    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(3, new EntityAIRunFromEntity(this, EntityDunkleosteus.class, 30.0F, 0.8D));
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, false));
        this.targetTasks.addTask(0, new EntityAITargetWater(this, EntityLivingBase.class, true, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity p_apply_1_) { return p_apply_1_ instanceof EntityPlayer || p_apply_1_ instanceof EntitySaurichthys; }})
        );
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.38D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(24.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return super.attackEntityFrom(source, amount);
    }

    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID, "models/entity/scorp/scorpion.png");
    }
    @Override
    public EntitySeaScorpion createChild(EntityAgeable entity){
        return new EntitySeaScorpion(this.world);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
        if(this.getRNG().nextInt(2) == 0){
            if(entityIn instanceof EntityLivingBase){
                ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, 60, 2));
                System.out.println("Test");
            }
        }
        return super.attackEntityAsMob(entityIn);
    }
}