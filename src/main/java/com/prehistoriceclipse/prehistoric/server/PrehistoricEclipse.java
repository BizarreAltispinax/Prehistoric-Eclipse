package com.prehistoriceclipse.prehistoric.server;

import com.dabigjoe.obsidianAPI.ObsidianEventHandler;
import com.dabigjoe.obsidianAPI.network.AnimationNetworkHandler;
import com.prehistoriceclipse.prehistoric.server.init.PEBlocks;
import com.prehistoriceclipse.prehistoric.server.init.PEItems;
import com.prehistoriceclipse.prehistoric.server.init.PERecipes;
import com.prehistoriceclipse.prehistoric.server.proxy.IProxy;
import com.prehistoriceclipse.prehistoric.server.proxy.ServerProxy;
import com.prehistoriceclipse.prehistoric.server.world.WorldProviderPreclipse;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, useMetadata = true)
public class PrehistoricEclipse {

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.Instance
    public static PrehistoricEclipse instance;

    public static final CreativeTabs creativeTab = (new CreativeTabs("prehistoric") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(PEItems.DAKOTARAPTOR_SKULL);
        }
    });

    public static SimpleNetworkWrapper NETWORK_WRAPPER;
    public static Logger logger;
    public static DimensionType dimensionType;
    public static ServerProxy PROXY;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit();

        dimensionType = DimensionType.register(Reference.MOD_ID, "_preclipse", 46, WorldProviderPreclipse.class, false);
        DimensionManager.registerDimension(46, dimensionType);

        try {
            PEItems.preInit();
            PEBlocks.preInit();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init();

        AnimationNetworkHandler.init();
        MinecraftForge.EVENT_BUS.register(new ObsidianEventHandler());
		PERecipes.onInit();
    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit();
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new TeleportCommand());
    }

}