package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.math.coordinate.entity;

import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinateProvider;

public class EntityCoordinateProvider implements IEntityCoordinateProvider
{
    private static EntityCoordinateProvider ourInstance = new EntityCoordinateProvider();

    public static EntityCoordinateProvider getInstance()
    {
        return ourInstance;
    }

    private EntityCoordinateProvider()
    {
    }

    @Override
    public IEntityCoordinate provide(final double x, final double y, final double z)
    {
        return new EntityCoordinate(x,y,z);
    }
}
