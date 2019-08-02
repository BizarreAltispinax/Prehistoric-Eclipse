package com.prehistoriceclipse.prehistoric.server.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PERecipes {
    public static void onInit() {
        GameRegistry.addSmelting(PEItems.DAKOTARAPTOR_MEAT, new ItemStack(PEItems.DAKOTARAPTOR_BEEF), 10.0F);
        GameRegistry.addSmelting(PEItems.MONOLOPHOSAURUS_MEAT, new ItemStack(PEItems.MONOLOPHOSAURUS_BEEF), 10.0F);
        GameRegistry.addSmelting(PEItems.REX_MEAT, new ItemStack(PEItems.REX_COOKED), 10.0F);
        GameRegistry.addSmelting(PEItems.PLESIOSAURUS_MEAT, new ItemStack(PEItems.PLESIOSAURUS_COOKED), 10.0F);
        GameRegistry.addSmelting(PEItems.VELOCIRAPTOR_MEAT, new ItemStack(PEItems.VELOCIRAPTOR_COOKED), 10.0F);
        GameRegistry.addSmelting(PEItems.MONOLOPHOSAURUS_CREST, new ItemStack(Items.COAL), 20.0F);   
        GameRegistry.addSmelting(PEItems.DAKOTARAPTOR_SKULL, new ItemStack(Items.COAL), 20.0F);
    }
}
