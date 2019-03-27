package com.ldtteam.jvoxelizer.launcher.forge_1_12.modloader;

import com.ldtteam.jvoxelizer.modloader.IModLoader;
import com.ldtteam.jvoxelizer.modloader.IModLoaderProvider;
import net.minecraftforge.fml.common.Loader;

public class ModLoaderProvider implements IModLoaderProvider
{
    private static ModLoaderProvider ourInstance = new ModLoaderProvider();

    public static ModLoaderProvider getInstance()
    {
        return ourInstance;
    }

    private ModLoaderProvider()
    {
    }

    @Override
    public IModLoader provide()
    {
        return ModLoader.fromForge(Loader.instance());
    }
}
