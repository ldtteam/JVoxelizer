package com.ldtteam.jvoxelizer.launcher.forge_1_12.modloader;

import com.ldtteam.jvoxelizer.modloader.IMod;
import com.ldtteam.jvoxelizer.modloader.IModLoader;
import net.minecraftforge.fml.common.Loader;

import java.util.List;
import java.util.stream.Collectors;

public class ModLoader implements IModLoader
{
    private Loader loader;

    private ModLoader(final Loader loader)
    {
        this.loader = loader;
    }

    @Override
    public List<IMod> getActiveModList()
    {
        return loader.getActiveModList().stream().map(Mod::fromForge).collect(Collectors.toList());
    }

    public static Loader asForge(final IModLoader modLoader)
    {
        if (modLoader instanceof Loader)
            return (Loader) modLoader;

        return ((ModLoader) modLoader).loader;
    }

    public static IModLoader fromForge(final Loader modLoader)
    {
        if (modLoader instanceof IModLoader)
            return (IModLoader) modLoader;

        return new ModLoader(modLoader);
    }
}
