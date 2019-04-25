package com.ldtteam.jvoxelizer.launcher.forge_1_13;

import com.ldtteam.jvoxelizer.discovery.IJVoxModPluginDiscoverer;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerSetupProxy;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.proxy.ClientProxy;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.proxy.CommonProxy;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.distribution.executor.DistributionExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public abstract class AbstractForgeMod
{

    private       Logger                     logger;
    private final String                     modId;
    private       IForgeJVoxelizerSetupProxy setupProxy;

    public AbstractForgeMod(final String modId)
    {
        this.modId = modId;
    }

    public void preInit(final FMLCommonSetupEvent event)
    {
        final Supplier<IForgeJVoxelizerSetupProxy> proxySupplier = DistributionExecutor.getInstance().runOn(
          () -> ClientProxy::new,
          () -> CommonProxy::new
        );

        this.setupProxy = proxySupplier.get();

        logger = LogManager.getLogger();
        logger.info("Initializing JVoxelizer.");

        registerProviders();
        IJVoxModPluginDiscoverer.get().discoverPlugins(ModList.get().getAllScanData());
    }

    private void registerProviders()
    {
        registerInternalProviders();
        registerModProviders();
    }

    private void registerInternalProviders()
    {
        this.setupProxy.onPreInit();
    }

    private void registerModProviders()
    {
        getModSetupProxy().onPreInit();
    }

    protected abstract IForgeJVoxelizerSetupProxy getModSetupProxy();

    protected void preInitializePlugins()
    {
        IJVoxModPluginDiscoverer.get().onPreInit(modId);
    }
}
