package com.prehistoriceclipse.prehistoric.server.block;

import com.prehistoriceclipse.prehistoric.server.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPrehistoric extends Block {
    public BlockPrehistoric(String name, Material material)
    {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(Reference.MOD_ID + ":" + name);
    }
}