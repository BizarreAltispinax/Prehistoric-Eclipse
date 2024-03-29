package com.prehistoriceclipse.prehistoric.server.entity.flying;

import com.prehistoriceclipse.prehistoric.server.Reference;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityDragonfly extends EntityAir {
    public EntityDragonfly(World world) {
        super(world);
        this.setSize(1.0F, 1.0F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
    }

    @Override
    public ResourceLocation getDefaultTexture() {
        return new ResourceLocation(Reference.MOD_ID + ":models/entity/mazo/male.png");
    }
    
    @Override
    public EntityDragonfly createChild(EntityAgeable entity){
        return new EntityDragonfly(this.world);
    }

    @Override
    public ResourceLocation getVariantTexture() {
        return new ResourceLocation(Reference.MOD_ID + ":models/entity/mazo/female.png");
    }
}
