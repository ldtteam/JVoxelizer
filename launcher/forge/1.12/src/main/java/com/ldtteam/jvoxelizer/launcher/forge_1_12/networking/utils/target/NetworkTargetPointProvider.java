package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.utils.target;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPoint;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPointProvider;
import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class NetworkTargetPointProvider implements INetworkTargetPointProvider
{
    private static NetworkTargetPointProvider ourInstance = new NetworkTargetPointProvider();

    public static NetworkTargetPointProvider getInstance()
    {
        return ourInstance;
    }

    private NetworkTargetPointProvider()
    {
    }

    @Override
    public INetworkTargetPoint provide(
      final IEntityCoordinate target, final double range, final IDimension dimension)
    {
        return NetworkTargetPoint.fromForge(new NetworkRegistry.TargetPoint(dimension.getId(), target.getX(), target.getY(), target.getZ(), range));
    }
}
