package com.prehistoriceclipse.prehistoric.server.world.biome;

import com.prehistoriceclipse.prehistoric.server.entity.aquatic.*;
import net.minecraft.world.biome.Biome;

public class BiomeStream extends BiomePrehistoric {
    public BiomeStream(){
        super(new BiomeProperties("Stream").setTemperature(0.8F).setBaseHeight(-0.5F).setHeightVariation(0.0F));
        this.setColors(4625193);
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntityPlesiosaurus.class, 95, 2, 5));
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntitySaurichthys.class, 90, 6, 7));
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntitySeaScorpion.class, 110, 3, 4));
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntityDunkleosteus.class, 100, 1, 1));
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntityMawsonia.class, 95, 2, 5));
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntityBawitius.class, 90, 6, 7));
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntityOnchopristis.class, 110, 3, 4));
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntityAmmonite.class, 100, 1, 1));
    }
}
