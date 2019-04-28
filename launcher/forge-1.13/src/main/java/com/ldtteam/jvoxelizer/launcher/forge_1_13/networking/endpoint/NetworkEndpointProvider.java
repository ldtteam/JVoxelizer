package com.ldtteam.jvoxelizer.launcher.forge_1_13.networking.endpoint;

import com.ldtteam.jvoxelizer.networking.endpoint.INetworkEndpoint;
import com.ldtteam.jvoxelizer.networking.endpoint.INetworkEndpointProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;

public class NetworkEndpointProvider implements INetworkEndpointProvider
{
    private static NetworkEndpointProvider ourInstance = new NetworkEndpointProvider();

    public static NetworkEndpointProvider getInstance()
    {
        return ourInstance;
    }

    private NetworkEndpointProvider()
    {
    }

    @Override
    public INetworkEndpoint provide(final String channelName)
    {
        return NetworkEndpoint.fromForge(NetworkRegistry.newSimpleChannel(new ResourceLocation("jvox_channel", channelName), () -> "1.0", s -> true, s -> true));
    }
}
