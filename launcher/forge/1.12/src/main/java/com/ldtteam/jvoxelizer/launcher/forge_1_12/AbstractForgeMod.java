package com.ldtteam.jvoxelizer.launcher.forge_1_12;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerSetupProxy;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.proxy.ClientProxy;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.proxy.CommonProxy;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.distribution.Distribution;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.distribution.executor.DistributionExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public abstract class AbstractForgeMod
{

    private Logger logger;

    private IForgeJVoxelizerSetupProxy setupProxy;

    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        final Supplier<IForgeJVoxelizerSetupProxy> proxySupplier = DistributionExecutor.getInstance().runOn(
          () -> ClientProxy::new,
          () -> CommonProxy::new
        );

        this.setupProxy = proxySupplier.get();

        logger = event.getModLog();
        logger.info("Initializing JVoxelizer.");

        registerProviders();
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
}
