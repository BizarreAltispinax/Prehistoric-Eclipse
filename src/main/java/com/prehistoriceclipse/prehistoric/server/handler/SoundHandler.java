package com.prehistoriceclipse.prehistoric.server.handler;

import com.prehistoriceclipse.prehistoric.server.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;


public class SoundHandler {

public static SoundEvent DAKORAPTOR_CALL, DAKORAPTOR_HURT, PLESIOSAURUS_HURT;
    
    public static void registerSounds() {
    	
    	//Dakoraptor
    	 DAKORAPTOR_CALL = registerSound("dakoraptor_call");
    	 DAKORAPTOR_HURT = registerSound("dakoraptor_hurt");
    	 
    	 //Plesiosaurus
    	 PLESIOSAURUS_HURT = registerSound("plesiosaurus_hurt");
        
    }
    
    public static SoundEvent registerSound(String name) {
        
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
