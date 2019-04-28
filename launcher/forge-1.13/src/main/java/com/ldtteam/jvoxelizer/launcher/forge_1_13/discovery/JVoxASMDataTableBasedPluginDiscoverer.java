package com.ldtteam.jvoxelizer.launcher.forge_1_13.discovery;

import com.google.common.collect.Maps;
import com.ldtteam.jvoxelizer.discovery.IJVoxModPlugin;
import com.ldtteam.jvoxelizer.discovery.IJVoxModPluginDiscoverer;
import com.ldtteam.jvoxelizer.discovery.IJVoxModPluginDiscovererProvider;
import net.minecraftforge.fml.common.LoaderException;
import net.minecraftforge.forgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import java.util.*;

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

        if (!(discoveryData instanceof List))
            throw new IllegalArgumentException("Can not discover from something other then ASMDatListaTable");

        final List<ModFileScanData> data = (List<ModFileScanData>) discoveryData;

        data.stream().map(ModFileScanData::getAnnotations).flatMap(Collection::stream).map(ModFileScanData.AnnotationData::getClassType).map(Type::getClassName).forEach(className -> {
            try
            {
                Class<?> subscriptionTarget = Class.forName(className.replace("/", "."));

                final Object pluginObject = subscriptionTarget.newInstance();
                final IJVoxModPlugin plugin = (IJVoxModPlugin) pluginObject;

                plugins.putIfAbsent(plugin.getTargetModId(), new ArrayList<>());
                plugins.get(plugin.getTargetModId()).add(plugin);
            }
            catch (Exception e)
            {
                throw new LoaderException(e);
            }
        });
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
