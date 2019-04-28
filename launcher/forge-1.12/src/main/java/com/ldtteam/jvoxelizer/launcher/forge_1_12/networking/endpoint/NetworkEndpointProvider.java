package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.endpoint;

import com.ldtteam.jvoxelizer.networking.endpoint.INetworkEndpoint;
import com.ldtteam.jvoxelizer.networking.endpoint.INetworkEndpointProvider;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

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
        return NetworkEndpoint.fromForge(new SimpleNetworkWrapper(channelName));
    }
}
