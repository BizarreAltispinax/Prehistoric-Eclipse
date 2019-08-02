package com.prehistoriceclipse.prehistoric.server.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy {
    void preInit(FMLPreInitializationEvent event);
    void registerItemRenderer(Item item, int meta, String id);
	void preInit();
	void init();
	void postInit();
}