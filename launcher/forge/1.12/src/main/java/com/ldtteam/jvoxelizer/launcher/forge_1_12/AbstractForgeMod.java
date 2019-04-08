package com.ldtteam.jvoxelizer.launcher.forge_1_12;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerSetupProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

public abstract class AbstractForgeMod
{

    private Logger logger;

    @SidedProxy(clientSide = "com.ldtteam.jvoxelizer.launcher.forge_1_12.proxy.ClientProxy", serverSide = "com.ldtteam.jvoxelizer.launcher.forge_1_12.proxy.CommonProxy")
    private IForgeJVoxelizerSetupProxy setupProxy;

    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
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
