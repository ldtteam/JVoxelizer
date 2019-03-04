package com.ldtteam.jvoxelizer.launcher.forge_1_12.biome;

import com.ldtteam.jvoxelizer.biome.IBiome;

public class Biome implements IBiome
{

    private final net.minecraft.world.biome.Biome forgeBiome;

    private Biome(final net.minecraft.world.biome.Biome forgeBiome) {this.forgeBiome = forgeBiome;}

    public net.minecraft.world.biome.Biome getForgeBiome()
    {
        return forgeBiome;
    }

    public static net.minecraft.world.biome.Biome asForge(IBiome biome)
    {
        if (biome instanceof net.minecraft.world.biome.Biome)
            return (net.minecraft.world.biome.Biome) biome;

        return ((Biome) biome).getForgeBiome();
    }

    public static IBiome fromForge(net.minecraft.world.biome.Biome biome)
    {
        if (biome instanceof IBiome)
            return (IBiome) biome;

        return new Biome(biome);
    }
}
