package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.entity;

import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import com.ldtteam.jvoxelizer.util.math.vector.floatingpoint.I3DoubleVector;

/**
 * TODO Orion is unsure about keeping this.
 */
public class EntityCoordinate implements IEntityCoordinate
{
    private I3DoubleVector vector;

    public EntityCoordinate(double x, double y, double z)
    {
        this(I3DoubleVector.create(x, y, z));
    }

    public EntityCoordinate(final I3DoubleVector vector)
    {
        this.vector = vector;
    }

    @Override
    public double getX()
    {
        return vector.getX();
    }

    @Override
    public double getY()
    {
        return vector.getY();
    }

    @Override
    public double getZ()
    {
        return vector.getZ();
    }
}
