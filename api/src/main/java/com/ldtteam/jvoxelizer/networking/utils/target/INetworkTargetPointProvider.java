package com.ldtteam.jvoxelizer.networking.utils.target;

import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import com.ldtteam.jvoxelizer.dimension.IDimension;

public interface INetworkTargetPointProvider
{

    INetworkTargetPoint provide(IEntityCoordinate target, double range, IDimension dimension);
}
