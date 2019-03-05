package com.ldtteam.jvoxelizer.biome;

/**
 * Represents a single biome definition in the world.
 */
public interface IBiome
{
    /**
     * Default {@link IBiome} in a {@link com.ldtteam.jvoxelizer.dimension.IDimension}.
     *
     * @return the default grass-topped flat {@link IBiome} for a normal {@link com.ldtteam.jvoxelizer.dimension.IDimension}.
     */
    static IBiome getPlains()
    {
        return IBiomeProviderHolder.getInstance().getPlains();
    }
}
