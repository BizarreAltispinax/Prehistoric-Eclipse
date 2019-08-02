package com.prehistoriceclipse.prehistoric.client.proxy;

import com.dabigjoe.obsidianAPI.file.importer.FileLoader;
import com.dabigjoe.obsidianAPI.registry.AnimationRegistry;
import com.prehistoriceclipse.prehistoric.client.model.ModelPrehistoric;
import com.prehistoriceclipse.prehistoric.client.render.RenderDakoArrow;
import com.prehistoriceclipse.prehistoric.client.render.RenderPrehistoric;
import com.prehistoriceclipse.prehistoric.server.Reference;
import com.prehistoriceclipse.prehistoric.server.entity.EntityEgg;
import com.prehistoriceclipse.prehistoric.server.entity.aquatic.*;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.*;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.*;
import com.prehistoriceclipse.prehistoric.server.entity.flying.EntityDragonfly;
import com.prehistoriceclipse.prehistoric.server.entity.flying.EntityTupandactylus;
import com.prehistoriceclipse.prehistoric.server.entity.projectile.EntityDakoArrow;
import com.prehistoriceclipse.prehistoric.server.init.PEAnimations;
import com.prehistoriceclipse.prehistoric.server.init.PEItems;
import com.prehistoriceclipse.prehistoric.server.proxy.IProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy implements IProxy {
    @Override
    public void preInit() {

    }
    @Override
    public void init() {
        RenderPrehistoric dakoRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("dakotaraptor", new ResourceLocation(Reference.MOD_ID + ":models/entity/dako/dakotaraptor.obm"), new ResourceLocation(Reference.MOD_ID + ":models/entity/dako/dakotaraptor.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityDakotaraptor.class, dakoRenderer);

        RenderPrehistoric monoRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("monolophosaurus", new ResourceLocation(Reference.MOD_ID + ":models/entity/mono/monolophosaurus.obm"), null, ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityMonolophosaurus.class, monoRenderer);

        RenderPrehistoric plesRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("plesiosaurus", new ResourceLocation(Reference.MOD_ID + ":models/entity/ples/plesiosaurus.obm"), null, ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityPlesiosaurus.class, plesRenderer);

        RenderPrehistoric veloRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("velociraptor", new ResourceLocation(Reference.MOD_ID + ":models/entity/velo/velociraptor_eclipse.obm"), new ResourceLocation(Reference.MOD_ID + ":models/entity/velo/velociraptor.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, veloRenderer);

        RenderPrehistoric titanRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("titanoceratops", new ResourceLocation(Reference.MOD_ID + ":models/entity/titan/titanoceratops.obm"), new ResourceLocation(Reference.MOD_ID + ":models/entity/titan/titanoceratops.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityTitanoceratops.class, titanRenderer);

        RenderPrehistoric eggRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("egg", new ResourceLocation(Reference.MOD_ID + ":models/entity/egg/egg.obm"), new ResourceLocation(Reference.MOD_ID + ":models/entity/egg/egg.png"), ModelPrehistoric.class), 0.0F);
        RenderingRegistry.registerEntityRenderingHandler(EntityEgg.class, eggRenderer);

        RenderPrehistoric dunkleoRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("dunkleosteus", new ResourceLocation(Reference.MOD_ID + ":models/entity/dunkleo/dunkleosteus.obm"), new ResourceLocation(Reference.MOD_ID + ":models/entity/dunkleo/dunkleosteus.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityDunkleosteus.class, dunkleoRenderer);

        RenderPrehistoric plateoRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("plateosaurus", new ResourceLocation(Reference.MOD_ID + ":models/entity/plateo/plateosaurus.obm"), null, ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityPlateosaurus.class, plateoRenderer);

        RenderPrehistoric arthroRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("arthropleura", new ResourceLocation(Reference.MOD_ID + ":models/entity/arthro/arthropleura.obm"), null, ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityArthropleura.class, arthroRenderer);

        RenderPrehistoric sauriRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("saurichthys", new ResourceLocation(Reference.MOD_ID + ":models/entity/sauri/saurichthys.obm"), null, ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntitySaurichthys.class, sauriRenderer);

        RenderPrehistoric rexRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("tyrannosaurusrex", new ResourceLocation(Reference.MOD_ID + ":models/entity/trex/tyrannosaurus_rex.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/trex/rex.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityTyrannosaurusRex.class, rexRenderer);

        RenderPrehistoric protoRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("protoceratops", new ResourceLocation(Reference.MOD_ID + ":models/entity/proto/protoceratops.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/proto/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityProtoceratops.class, protoRenderer);

        RenderPrehistoric scorpRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("seascorpion", new ResourceLocation(Reference.MOD_ID + ":models/entity/scorp/sea_scorpion.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/scorp/scorpion.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntitySeaScorpion.class, scorpRenderer);

        RenderPrehistoric pachyRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("pachycephalosaurus", new ResourceLocation(Reference.MOD_ID + ":models/entity/pachy/pachycephalosaurus.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/pachy/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityPachycephalosaurus.class, pachyRenderer);

        RenderPrehistoric dragonRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("dragonfly", new ResourceLocation(Reference.MOD_ID + ":models/entity/mazo/mazothairos.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/mazo/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityDragonfly.class, dragonRenderer);

        RenderPrehistoric tupanRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("tupandactylus", new ResourceLocation(Reference.MOD_ID + ":models/entity/tupan/tupandactylus.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/tupan/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityTupandactylus.class, tupanRenderer);

        RenderPrehistoric alloRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("allosaurus", new ResourceLocation(Reference.MOD_ID + ":models/entity/allo/allosaurus.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/allo/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityAllosaurus.class, alloRenderer);

        RenderPrehistoric saurRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("sauroposeidon", new ResourceLocation(Reference.MOD_ID + ":models/entity/saur/sauroposeidon.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/saur/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntitySauroposeidon.class, saurRenderer);

        RenderPrehistoric onchoRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("onchopristis", new ResourceLocation(Reference.MOD_ID + ":models/entity/oncho/onchopristis.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/oncho/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityOnchopristis.class, onchoRenderer);
        
        RenderPrehistoric mawsRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("mawsonia", new ResourceLocation(Reference.MOD_ID + ":models/entity/maws/mawsonia.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/maws/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityMawsonia.class, mawsRenderer);
        
        RenderPrehistoric ceratoRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("ceratosaurus", new ResourceLocation(Reference.MOD_ID + ":models/entity/cerato/ceratosaurus.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/cerato/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityCeratosaurus.class, ceratoRenderer);
        
        RenderPrehistoric theriRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("therizinosaurus", new ResourceLocation(Reference.MOD_ID + ":models/entity/theri/therizinosaurus.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/theri/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityTherizinosaurus.class, theriRenderer);
        
        RenderPrehistoric ammoniteRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("ammonite", new ResourceLocation(Reference.MOD_ID + ":models/entity/ammonite/ammonite.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/ammonite/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityAmmonite.class, ammoniteRenderer);
        
        RenderPrehistoric spinoRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("spinosaurus", new ResourceLocation(Reference.MOD_ID + ":models/entity/spino/spinosaurus.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/spino/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntitySpinosaurus.class, spinoRenderer);
        
        RenderPrehistoric archaeoRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("archaeopteryx", new ResourceLocation(Reference.MOD_ID + ":models/entity/archaeo/archaeopteryx.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/archaeo/male.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityArchaeopteryx.class, archaeoRenderer);
        
        RenderPrehistoric bawRenderer = new RenderPrehistoric(FileLoader.loadModelFromResources("bawitius", new ResourceLocation(Reference.MOD_ID + ":models/entity/baw/bawitius.obm"), new ResourceLocation(Reference.MOD_ID, "models/entity/baw/bawitiusm.png"), ModelPrehistoric.class));
        RenderingRegistry.registerEntityRenderingHandler(EntityBawitius.class, bawRenderer);


        RenderingRegistry.registerEntityRenderingHandler(EntityDakoArrow.class, renderManager -> new RenderDakoArrow(renderManager));

        AnimationRegistry.init();
        PEAnimations.registerAnimations();

        Minecraft.getMinecraft().getItemColors().registerItemColorHandler((stack, tintIndex) -> {
            EntityList.EntityEggInfo egg = EntityList.ENTITY_EGGS.get(ItemMonsterPlacer.getNamedIdFrom(stack));
            if (egg == null) return -1;
            else return tintIndex == 0 ? egg.primaryColor : egg.secondaryColor;
        }, PEItems.DINOSAUR_EGG);
    }
    @Override
    public void postInit(){

    }
	@Override
	public void preInit(FMLPreInitializationEvent event) {		
	}
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
	}
}
