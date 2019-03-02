package com.ldtteam.jvoxelizer.launcher.forge_1_12;

import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.core.provider.holder.ProviderResolver;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.biome.BiomeProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state.BlockStateProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt.NBTProvider;
import com.ldtteam.jvoxelizer.util.nbt.INBTBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.security.Provider;

public abstract class AbstractForgeMod
{

    private Logger logger;

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
        //Biome
        ProviderResolver.getInstance().registerProvider(IBiome.class.getName(), BiomeProvider.getInstance());

        //Block
        ProviderResolver.getInstance().registerProvider(IBlockState.class.getName(), BlockStateProvider.getInstance());

        //Util
        ProviderResolver.getInstance().registerProvider(INBTBase.class.getName(), NBTProvider.getInstance());
    }

    protected abstract void registerModProviders();


}
