package com.ldtteam.jvoxelizer.launcher.forge_1_12.modloader;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.modloader.IMod;
import com.ldtteam.jvoxelizer.modloader.IModLoader;
import net.minecraftforge.fml.common.Loader;

import java.util.List;
import java.util.stream.Collectors;

public class ModLoader implements IModLoader, IForgeJVoxelizerWrapper
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

    private Loader getLoader()
    {
        return loader;
    }

    public static Loader asForge(final IModLoader modLoader)
    {
        if (modLoader instanceof Loader)
            return (Loader) modLoader;

        if (!(modLoader instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("ModLoader is not a wrapper");

        return ((IForgeJVoxelizerWrapper) modLoader).getForgeInstance();
    }

    public static IModLoader fromForge(final Loader modLoader)
    {
        if (modLoader instanceof IModLoader)
            return (IModLoader) modLoader;

        return new ModLoader(modLoader);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getLoader();
    }
}
