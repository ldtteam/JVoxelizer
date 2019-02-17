package com.ldtteam.jvoxelizer.networking.endpoint;

public interface INetworkEndpointProvider
{

    INetworkEndpoint provide(String channelName);
}
