package com.prehistoriceclipse.prehistoric.server.world.biome;

import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityVelociraptor;
import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;

import java.util.Random;

public class BiomeOrientValley extends BiomePrehistoric {

    private static final WorldGenMegaPineTree SPRUCE = new WorldGenMegaPineTree(false, true);

    public BiomeOrientValley() {
        super(new BiomeProperties("Orient Valley").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled());
        this.decorator.grassPerChunk = 7;
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityVelociraptor.class, 100, 4, 8));
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();
        if (noiseVal > 1.75D) this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
        else if (noiseVal > -0.95D) this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
        super.genTerrainBlocks(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return SPRUCE;
    }
}
