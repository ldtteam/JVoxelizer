package com.ldtteam.jvoxelizer.launcher.forge_1_12.biome;

import com.ldtteam.jvoxelizer.biome.IBiome;

public class Biome implements IBiome
{

    private final net.minecraft.world.biome.Biome forgeBiome;

    public Biome(final net.minecraft.world.biome.Biome forgeBiome) {this.forgeBiome = forgeBiome;}

    public net.minecraft.world.biome.Biome getForgeBiome()
    {
        return forgeBiome;
    }
}
