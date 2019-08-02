package com.prehistoriceclipse.prehistoric.server.entity.flying;

import com.prehistoriceclipse.prehistoric.server.Reference;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityTupandactylus extends EntityAir {
    public EntityTupandactylus(World world) {
        super(world);
        this.setSize(1.2F, 1.2F);
     }
        @Override
        protected void initEntityAI() {
            super.initEntityAI();
        }

        @Override
        protected void applyEntityAttributes() {
            super.applyEntityAttributes();
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(28.0D);
            this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        }
    
    @Override
    public EntityTupandactylus createChild(EntityAgeable entity){
        return new EntityTupandactylus(this.world);
    }

    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(Reference.MOD_ID + ":models/entity/tupan/male.png");
    }
}
