package com.ldtteam.jvoxelizer.discovery;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IJVoxModPluginDiscovererProviderHolder extends AbstractHolder<IJVoxModPluginDiscovererProvider> implements IJVoxModPluginDiscovererProvider
{
    private static IJVoxModPluginDiscovererProviderHolder ourInstance = new IJVoxModPluginDiscovererProviderHolder();

    public static IJVoxModPluginDiscovererProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IJVoxModPluginDiscovererProviderHolder()
    {
        super(IJVoxModPluginDiscoverer.class.getName());
    }

    @Override
    public IJVoxModPluginDiscoverer provide()
    {
        return getProvider().provide();
    }
}