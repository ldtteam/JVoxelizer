package com.ldtteam.jvoxelizer.networking.utils.target;

import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import com.ldtteam.jvoxelizer.dimension.IDimension;

public interface INetworkTargetPoint
{

    static INetworkTargetPoint create(IEntityCoordinate coordinate, double range, IDimension dimension)
    {
        return INetworkTargetPointProviderHolder.getInstance().provide(coordinate, range, dimension);
    }

    IEntityCoordinate getTarget();

    double getRange();

    IDimension getDimension();
}
