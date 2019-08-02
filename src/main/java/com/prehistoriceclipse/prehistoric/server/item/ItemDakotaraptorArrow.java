package com.prehistoriceclipse.prehistoric.server.item;

import com.prehistoriceclipse.prehistoric.server.PrehistoricEclipse;
import com.prehistoriceclipse.prehistoric.server.entity.projectile.EntityDakoArrow;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDakotaraptorArrow extends ItemArrow {

    public ItemDakotaraptorArrow(){
        setRegistryName("dakotaraptor_arrow");
        setUnlocalizedName("dakotaraptor_arrow");
        setCreativeTab(PrehistoricEclipse.creativeTab);
    }
    @Override
    public EntityDakoArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
    {
        return new EntityDakoArrow(worldIn, shooter);
    }
}
