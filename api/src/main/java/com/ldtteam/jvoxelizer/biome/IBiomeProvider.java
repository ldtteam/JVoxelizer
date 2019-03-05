package com.ldtteam.jvoxelizer.biome;

/**
 * The default provider that handles creation and access to the default Biomes.
 */
public interface IBiomeProvider
{
    /**
     * Gives access to the default grass-topped flat {@link IBiome}.
     *
     * @return the default grass-topped flat {@link IBiome}.
     */
    IBiome getPlains();
}
