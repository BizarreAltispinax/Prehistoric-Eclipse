package com.prehistoriceclipse.prehistoric.server.init;

import com.prehistoriceclipse.prehistoric.server.PrehistoricEclipse;
import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.EntityEgg;
import com.prehistoriceclipse.prehistoric.server.entity.ai.Diet;
import com.prehistoriceclipse.prehistoric.server.entity.aquatic.*;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.*;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.*;
import com.prehistoriceclipse.prehistoric.server.entity.flying.EntityDragonfly;
import com.prehistoriceclipse.prehistoric.server.entity.flying.EntityTupandactylus;
import com.prehistoriceclipse.prehistoric.server.entity.projectile.EntityDakoArrow;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class PEEntities {

	private static int id = 1;


    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Dakotaraptor"),EntityDakotaraptor.class, "Dakotaraptor", id++, PrehistoricEclipse.instance, 64, 3, true, 0x2B2115 , 0x324334);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Monolophosaurus"),EntityMonolophosaurus.class, "Monolophosaurus", id++, PrehistoricEclipse.instance, 64, 3, true, 0x4F5729 , 0x231F14);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Plesiosaurus"),EntityPlesiosaurus.class, "Plesiosaurus", id++, PrehistoricEclipse.instance, 64, 3, true, 0xD9D7BF , 0x1E1B18);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Velociraptor"),EntityVelociraptor.class, "Velociraptor", id++, PrehistoricEclipse.instance, 64, 3, true, 0xC59958 , 0x1E1C1A);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Titanoceratops"),EntityTitanoceratops.class, "Titanoceratops", id++, PrehistoricEclipse.instance, 64, 3, true, 0xB86C36 , 0xE9D3C4);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Dunkleosteus"),EntityDunkleosteus.class, "Dunkleosteus", id++, PrehistoricEclipse.instance, 64, 3, true, 0x2E393D , 0xC9BDA6);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Plateosaurus"),EntityPlateosaurus.class, "Plateosaurus", id++, PrehistoricEclipse.instance, 64, 3, true, 0xDF8E53 , 0x090509);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Arthropleura"),EntityArthropleura.class, "Arthropleura", id++, PrehistoricEclipse.instance, 64, 3, true, 0x4C1F1F , 0xE6BB90);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Saurichthys"),EntitySaurichthys.class, "Saurichthys", id++, PrehistoricEclipse.instance, 64, 3, true, 0x64A485 , 0x37614D);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "TyrannosaurusRex"),EntityTyrannosaurusRex.class, "TyrannosaurusRex", id++, PrehistoricEclipse.instance, 64, 3, true, 0x120F09 , 0xA98C62);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Protoceratops"),EntityProtoceratops.class, "Protoceratops", id++, PrehistoricEclipse.instance, 64, 3, true, 0x393634 , 0xCDD9E2);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "SeaScorpion"),EntitySeaScorpion.class, "SeaScorpion", id++, PrehistoricEclipse.instance, 64, 3, true, 0x270100 , 0x893322);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Pachycephalosaurus"),EntityPachycephalosaurus.class, "Pachycephalosaurus", id++, PrehistoricEclipse.instance, 64, 3, true, 0x694530 , 0xF2C6A3);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Dragonfly"),EntityDragonfly.class, "Dragonfly", id++, PrehistoricEclipse.instance, 64, 3, true, 0x563D0C , 0x876625);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Tupandactylus"),EntityTupandactylus.class, "Tupandactylus", id++, PrehistoricEclipse.instance, 64, 3, true, 0x360D00 , 0xC6B68A);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Allosaurus"),EntityAllosaurus.class, "Allosaurus", id++, PrehistoricEclipse.instance, 64, 3, true, 0x54442D , 0xC39B66);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Sauroposeidon"),EntitySauroposeidon.class, "Sauroposeidon", id++, PrehistoricEclipse.instance, 64, 3, true, 0x100B07 , 0x5E3921);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Onchopristis"),EntityOnchopristis.class, "Onchopristis", id++, PrehistoricEclipse.instance, 64, 3, true, 0x15161B , 0xC8CBD1);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Mawsonia"),EntityMawsonia.class, "Mawsonia", id++, PrehistoricEclipse.instance, 64, 3, true, 0x4E501E , 0x8B8B4A);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Ceratosaurus"),EntityCeratosaurus.class, "Ceratosaurus", id++, PrehistoricEclipse.instance, 64, 3, true, 0x191919 , 0x949187);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Therizinosaurus"),EntityTherizinosaurus.class, "Therizinosaurus", id++, PrehistoricEclipse.instance, 64, 3, true, 0x1D1C18 , 0x924D35);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Ammonite"),EntityAmmonite.class, "Ammonite", id++, PrehistoricEclipse.instance, 64, 3, true, 0xFAFFFF , 0xA5322E);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Spinosaurus"),EntitySpinosaurus.class, "Spinosaurus", id++, PrehistoricEclipse.instance, 64, 3, true, 0x473C39 , 0x751D19);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Archaeopteryx"),EntityArchaeopteryx.class, "Archaeopteryx", id++, PrehistoricEclipse.instance, 64, 3, true, 0x523B16 , 0xC6C5C1);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Bawitius"),EntityBawitius.class, "Bawitius", id++, PrehistoricEclipse.instance, 64, 3, true, 0x333927 , 0x4C593B);

        registerEntity(EntityEgg.class, "Egg", false);
        registerEntity(EntityDakoArrow.class, "DakoArrow", false);
    }

    private static void registerEntity(Class entityClass, String name, boolean egg) {
    	EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, name), entityClass, name, id++, PrehistoricEclipse.instance, 64, 3, true);
    }
    
    private final Class<? extends Entity> entity;
	public MobType type;
	public Diet diet;
	public TimePeriod period;
	
	PEEntities(Class <? extends Entity> entity, MobType type, TimePeriod period, Diet diet) {
		this.entity = entity;
		this.type = type;
		this.period = period;
		this.diet = diet;
		}
}
