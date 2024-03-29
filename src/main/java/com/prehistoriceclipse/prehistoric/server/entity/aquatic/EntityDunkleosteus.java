package com.prehistoriceclipse.prehistoric.server.entity.aquatic;

import com.google.common.base.Predicate;
import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.ai.EntityAITargetWater;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityVelociraptor;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityPachycephalosaurus;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityPlateosaurus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityDunkleosteus extends EntityAquatic {

    public EntityDunkleosteus(World worldIn)
    {
        super(worldIn);
        this.setSize(2.0F, 2.0F);
    }
    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, false));
        this.targetTasks.addTask(0, new EntityAITargetWater(this, EntityLivingBase.class, true, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity p_apply_1_) { return p_apply_1_ instanceof EntityPig || p_apply_1_ instanceof EntityCow || p_apply_1_ instanceof EntityPlesiosaurus || p_apply_1_ instanceof EntitySeaScorpion || p_apply_1_ instanceof EntitySaurichthys || p_apply_1_ instanceof EntityPlayer || p_apply_1_ instanceof EntitySquid || p_apply_1_ instanceof EntityPachycephalosaurus || p_apply_1_ instanceof EntityPlateosaurus || p_apply_1_ instanceof EntityOnchopristis || p_apply_1_ instanceof EntityVelociraptor || p_apply_1_ instanceof EntityMawsonia; }})
        );
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(37.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
    }

    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return super.attackEntityFrom(source, amount);
    }

    public ResourceLocation getDefaultTexture(){
        return new ResourceLocation(Reference.MOD_ID + ":models/entity/dunkleo/dunkleosteus.png");
    }

    @Override
    public EntityDunkleosteus createChild(EntityAgeable entity){
        return new EntityDunkleosteus(this.world);
    }
}