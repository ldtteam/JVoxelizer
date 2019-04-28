package com.ldtteam.jvoxelizer.launcher.forge_1_13.biome;

import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;

public class Biome implements IBiome, IForgeJVoxelizerWrapper
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
        {
            return (net.minecraft.world.biome.Biome) biome;
        }

        if (biome == null)
        {
            return null;
        }

        if (!(biome instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("Biome is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) biome).getForgeInstance();
    }

    public static IBiome fromForge(net.minecraft.world.biome.Biome biome)
    {
        if (biome instanceof IBiome)
        {
            return (IBiome) biome;
        }

        return new Biome(biome);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeBiome();
    }
}
