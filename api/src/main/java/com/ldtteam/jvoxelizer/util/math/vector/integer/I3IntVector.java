package com.ldtteam.jvoxelizer.util.math.vector.integer;

/**
 * Represents a vector made up out of 3 integers.
 */
public interface I3IntVector
{

    static I3IntVector create(int x, int y, int z)
    {
        return I3IntVectorProviderHolder.getInstance().provide(x, y, z);
    }

    /**
     * The first, x, coordinate of the vector.
     *
     * @return x
     */
    int getX();

    /**
     * The first, y, coordinate of the vector.
     *
     * @return y
     */
    int getY();

    /**
     * The first, z, coordinate of the vector.
     *
     * @return z
     */
    int getZ();
}
