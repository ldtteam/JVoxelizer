package com.ldtteam.jvoxelizer.launcher.forge_1_12.discovery;

import com.google.common.collect.Maps;
import com.google.common.collect.SetMultimap;
import com.ldtteam.jvoxelizer.discovery.IJVoxModPlugin;
import com.ldtteam.jvoxelizer.discovery.IJVoxModPluginDiscoverer;
import com.ldtteam.jvoxelizer.discovery.IJVoxModPluginDiscovererProvider;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.LoaderException;
import net.minecraftforge.fml.common.discovery.ASMDataTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JVoxASMDataTableBasedPluginDiscoverer implements IJVoxModPluginDiscoverer, IJVoxModPluginDiscovererProvider
{
    private static JVoxASMDataTableBasedPluginDiscoverer ourInstance = new JVoxASMDataTableBasedPluginDiscoverer();

    public static JVoxASMDataTableBasedPluginDiscoverer getInstance()
    {
        return ourInstance;
    }

    private Boolean loaded = false;
    private final Map<String, List<IJVoxModPlugin>> plugins = Maps.newHashMap();

    private JVoxASMDataTableBasedPluginDiscoverer()
    {
    }

    @Override
    public void discoverPlugins(Object discoveryData)
    {
        if (loaded)
            return;

        loaded = true;

        if (!(discoveryData instanceof ASMDataTable))
            throw new IllegalArgumentException("Can not discover from something other then ASMDataTable");

        final ASMDataTable data = (ASMDataTable) discoveryData;

        final Set<ASMDataTable.ASMData> targets = data.getAll(IJVoxModPlugin.class.getName().replace(".", "/"));
        ClassLoader mcl = Loader.instance().getModClassLoader();

        for (ASMDataTable.ASMData target : targets)
        {
            try
            {
                Class<?> subscriptionTarget = Class.forName(target.getClassName().replace("/", "."), true, mcl);

                final Object pluginObject = subscriptionTarget.newInstance();
                final IJVoxModPlugin plugin = (IJVoxModPlugin) pluginObject;

                plugins.putIfAbsent(plugin.getTargetModId(), new ArrayList<>());
                plugins.get(plugin.getTargetModId()).add(plugin);
            }
            catch (Exception e)
            {
                throw new LoaderException(e);
            }
        }
    }

    @Override
    public void onPreInit(final String modId)
    {
        plugins.getOrDefault(modId, new ArrayList<>()).forEach(IJVoxModPlugin::onPreInit);
    }

    @Override
    public IJVoxModPluginDiscoverer provide()
    {
        return getInstance();
    }
}
