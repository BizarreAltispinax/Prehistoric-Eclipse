package com.prehistoriceclipse.prehistoric.server.proxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod.EventBusSubscriber
public class ServerProxy implements IProxy{

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
    }
    
    public void spawnPacketBlockParticles(World worldObj, float f, float f1, float f2, double motionX, double motionY, double motionZ, Block block) {
    }
    
    public void spawnPacketItemParticles(World worldObj, float f, float f1, float f2, double motionX, double motionY, double motionZ, Item item) {

    }

	@Override
	public void preInit() {
	}

	@Override
	public void init() {
	}

	@Override
	public void postInit() {
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
	}
}
