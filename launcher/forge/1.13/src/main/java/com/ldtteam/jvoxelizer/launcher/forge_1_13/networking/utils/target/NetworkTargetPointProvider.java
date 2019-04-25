package com.ldtteam.jvoxelizer.launcher.forge_1_13.networking.utils.target;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension.Dimension;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPoint;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPointProvider;
import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;

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
        return NetworkTargetPoint.fromForge(new PacketDistributor.TargetPoint(target.getX(), target.getY(), target.getZ(), range, Dimension.asForge(dimension).dimension.getType()));
    }
}
