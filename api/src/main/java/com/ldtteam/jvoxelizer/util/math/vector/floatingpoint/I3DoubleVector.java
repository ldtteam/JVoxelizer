package com.ldtteam.jvoxelizer.util.math.vector.floatingpoint;

/**
 * Represents a vector made up out of 3 doubles.
 */
public interface I3DoubleVector
{

    static I3DoubleVector create(double x, double y, double z)
    {
        return I3DoubleVectorProviderHolder.getInstance().provide(x, y, z);
    }

    /**
     * The first, x, coordinate of the vector.
     *
     * @return x
     */
    double getX();

    /**
     * The first, y, coordinate of the vector.
     *
     * @return y
     */
    double getY();

    /**
     * The first, z, coordinate of the vector.
     *
     * @return z
     */
    double getZ();
}
