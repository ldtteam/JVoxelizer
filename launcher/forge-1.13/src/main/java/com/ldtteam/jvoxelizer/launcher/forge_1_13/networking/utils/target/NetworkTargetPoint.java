package com.ldtteam.jvoxelizer.launcher.forge_1_13.networking.utils.target;

import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPoint;
import net.minecraftforge.fml.network.PacketDistributor;

public class NetworkTargetPoint implements INetworkTargetPoint
{
    private PacketDistributor.TargetPoint target;

    private NetworkTargetPoint(final PacketDistributor.TargetPoint target)
    {
        this.target = target;
    }

    private PacketDistributor.TargetPoint getForgeTargetPoint()
    {
        return this.target;
    }

    public static INetworkTargetPoint fromForge(PacketDistributor.TargetPoint target)
    {
        return new NetworkTargetPoint(target);
    }

    public static PacketDistributor.TargetPoint asForge(INetworkTargetPoint targetPoint)
    {
        return ((NetworkTargetPoint) targetPoint).getForgeTargetPoint();
    }
}
