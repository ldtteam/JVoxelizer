package com.ldtteam.jvoxelizer.discovery;

public interface IJVoxModPluginDiscoverer
{

    static IJVoxModPluginDiscoverer get()
    {
        return IJVoxModPluginDiscovererProviderHolder.getInstance().provide();
    }

    void discoverPlugins(Object discoveryData);

    void onPreInit(String modId);
}
