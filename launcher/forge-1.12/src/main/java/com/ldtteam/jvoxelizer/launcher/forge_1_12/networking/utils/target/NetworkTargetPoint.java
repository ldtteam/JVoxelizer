package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.utils.target;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.entity.EntityCoordinate;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.vector.floatingpoint.ThreeDoubleVector;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPoint;
import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class NetworkTargetPoint implements INetworkTargetPoint
{
    private NetworkRegistry.TargetPoint target;

    private NetworkTargetPoint(final NetworkRegistry.TargetPoint target)
    {
        this.target = target;
    }

    private NetworkRegistry.TargetPoint getForgeTargetPoint()
    {
        return this.target;
    }

    public static INetworkTargetPoint fromForge(NetworkRegistry.TargetPoint target)
    {
        return new NetworkTargetPoint(target);
    }

    public static NetworkRegistry.TargetPoint asForge(INetworkTargetPoint targetPoint)
    {
        return ((NetworkTargetPoint) targetPoint).getForgeTargetPoint();
    }
}
