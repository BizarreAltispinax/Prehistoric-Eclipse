package com.prehistoriceclipse.prehistoric.server.world.biome;

import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.carnivore.EntityDakotaraptor;
import com.prehistoriceclipse.prehistoric.server.entity.dinosaur.herbivore.EntityPlateosaurus;
import net.minecraft.block.BlockDirt;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;

import java.util.Random;

public class BiomeDawnForest extends BiomePrehistoric{

    private static final WorldGenMegaPineTree TREE = new WorldGenMegaPineTree(false, false);

    public BiomeDawnForest(){
        super(new BiomeProperties("Dawn Forest").setBaseHeight(0.3F).setHeightVariation(0.2F).setTemperature(0.1F));

        this.decorator.treesPerChunk = 8;
        this.decorator.grassPerChunk = 2;
        this.decorator.reedsPerChunk = 20;
        this.decorator.grassPerChunk = 3;
        this.setColors(0x0A5F00);

        this.spawnableCreatureList.add(new SpawnListEntry(EntityPlateosaurus.class, 10, 3, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPlateosaurus.class, 10, 3, 6));
    }
    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        this.topBlock = Blocks.GRASS.getDefaultState();

        if (noiseVal > 1.75D) {
            this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
        }
        else if (noiseVal > -0.95D) {
            this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
        }
        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }
    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return TREE;
    }
}
