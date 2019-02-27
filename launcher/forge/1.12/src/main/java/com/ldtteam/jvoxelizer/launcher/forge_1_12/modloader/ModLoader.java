package com.ldtteam.jvoxelizer.launcher.forge_1_12.modloader;

import com.ldtteam.jvoxelizer.modloader.IMod;
import com.ldtteam.jvoxelizer.modloader.IModLoader;
import net.minecraftforge.fml.common.Loader;

import java.util.List;
import java.util.stream.Collectors;

public class ModLoader implements IModLoader
{
    private Loader loader;

    public ModLoader(final Loader loader)
    {
        this.loader = loader;
    }

    @Override
    public List<IMod> getActiveModList()
    {
        return loader.getActiveModList().stream().map(Mod::new).collect(Collectors.toList());
    }
}
