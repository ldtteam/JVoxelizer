package com.ldtteam.jvoxelizer.launcher.forge_1_13.modloader;

import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.modloader.IMod;
import com.ldtteam.jvoxelizer.modloader.IModLoader;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ModLoader implements IModLoader, IForgeJVoxelizerWrapper
{
    private net.minecraftforge.fml.ModLoader loader;

    private ModLoader(final net.minecraftforge.fml.ModLoader loader)
    {
        this.loader = loader;
    }

    @Override
    public List<IMod> getActiveModList()
    {
        return ModList.get().getMods().stream().map(info -> ModList.get().getModContainerById(info.getModId())).filter(Optional::isPresent).map(Optional::get).map(Mod::fromForge).collect(Collectors.toList());
    }

    private net.minecraftforge.fml.ModLoader getLoader()
    {
        return loader;
    }

    public static net.minecraftforge.fml.ModLoader asForge(final IModLoader modLoader)
    {
        if (modLoader instanceof net.minecraftforge.fml.ModLoader)
        {
            return (net.minecraftforge.fml.ModLoader) modLoader;
        }

        if (modLoader == null)
        {
            return null;
        }

        if (!(modLoader instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("ModLoader is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) modLoader).getForgeInstance();
    }

    public static IModLoader fromForge(final net.minecraftforge.fml.ModLoader modLoader)
    {
        if (modLoader instanceof IModLoader)
        {
            return (IModLoader) modLoader;
        }

        return new ModLoader(modLoader);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getLoader();
    }
}
