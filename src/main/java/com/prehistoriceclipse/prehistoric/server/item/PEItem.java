package com.prehistoriceclipse.prehistoric.server.item;

import com.prehistoriceclipse.prehistoric.server.PrehistoricEclipse;
import net.minecraft.item.Item;

public class PEItem extends Item {
    public PEItem(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(PrehistoricEclipse.creativeTab);
    }
}
