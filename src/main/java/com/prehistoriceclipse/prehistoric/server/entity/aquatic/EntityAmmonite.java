package com.prehistoriceclipse.prehistoric.server.entity.aquatic;

import com.prehistoriceclipse.prehistoric.server.Reference;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityAmmonite extends EntityAquatic {

    public EntityAmmonite(World worldIn) {
        super(worldIn);
        this.setSize(1.5F, 1.2F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.175D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        return super.attackEntityFrom(source, amount);
    }

    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(Reference.MOD_ID, "models/entity/ammonite/male.png");
    }

    @Override
    public EntityAmmonite createChild(EntityAgeable entity) {
        return new EntityAmmonite(this.world);
    }
    
	public boolean doesFlock() {
		return false;
	}
}