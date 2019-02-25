package com.ldtteam.jvoxelizer.launcher.forge_1_12.biome;

import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.biome.IBiomeProvider;
import net.minecraft.init.Biomes;

public class BiomeProvider implements IBiomeProvider
{
    private static BiomeProvider ourInstance = new BiomeProvider();

    public static BiomeProvider getInstance()
    {
        return ourInstance;
    }

    private BiomeProvider()
    {
    }

    @Override
    public IBiome getPlains()
    {
        return new Biome(Biomes.PLAINS);
    }
}
