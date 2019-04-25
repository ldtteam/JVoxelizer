package com.ldtteam.jvoxelizer.launcher.forge_1_13.modloader;

import com.ldtteam.jvoxelizer.modloader.IModLoader;
import com.ldtteam.jvoxelizer.modloader.IModLoaderProvider;

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
        return ModLoader.fromForge(net.minecraftforge.fml.ModLoader.get());
    }
}
