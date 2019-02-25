package com.ldtteam.jvoxelizer.biome;

public interface IBiome
{
    static IBiome getPlains()
    {
        return IBiomeProviderHolder.getInstance().getPlains();
    }
}
