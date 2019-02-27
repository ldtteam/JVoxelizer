package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.utils.target;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPoint;
import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;

//TODO Orion?
public class NetworkTargetPoint implements INetworkTargetPoint
{
    @Override
    public IEntityCoordinate getTarget()
    {
        return null;
    }

    @Override
    public double getRange()
    {
        return 0;
    }

    @Override
    public IDimension getDimension()
    {
        return null;
    }
}
