package com.ldtteam.jvoxelizer.networking.endpoint;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class INetworkEndpointProviderHolder extends AbstractHolder<INetworkEndpointProvider> implements INetworkEndpointProvider
{
    private static INetworkEndpointProviderHolder ourInstance = new INetworkEndpointProviderHolder();

    public static INetworkEndpointProviderHolder getInstance()
    {
        return ourInstance;
    }

    private INetworkEndpointProviderHolder()
    {
        super(INetworkEndpoint.class.getName());
    }

    @Override
    public INetworkEndpoint provide(final String channelName)
    {
        return getProvider().provide(channelName);
    }
}
