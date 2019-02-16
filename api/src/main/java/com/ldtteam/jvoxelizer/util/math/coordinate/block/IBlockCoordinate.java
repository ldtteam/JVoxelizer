package com.ldtteam.jvoxelizer.util.math.coordinate.block;

import com.ldtteam.jvoxelizer.util.math.vector.integer.I3IntVector;

/**
 * Represents a coordinate in the 3D space of the game world
 */
public interface IBlockCoordinate extends I3IntVector
{

    static IBlockCoordinate create(int x, int y, int z)
    {
        return BlockCoordinateProviderHolder.getInstance().provide(x, y, z);
    }

}
