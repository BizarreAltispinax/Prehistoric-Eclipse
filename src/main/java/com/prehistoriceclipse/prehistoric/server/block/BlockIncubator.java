package com.prehistoriceclipse.prehistoric.server.block;


import com.prehistoriceclipse.prehistoric.server.PrehistoricEclipse;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockIncubator extends BlockPrehistoric {
    public BlockIncubator() {
        super("incubator", Material.CIRCUITS);
        this.setCreativeTab(PrehistoricEclipse.creativeTab);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}