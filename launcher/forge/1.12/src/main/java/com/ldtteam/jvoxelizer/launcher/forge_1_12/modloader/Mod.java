package com.ldtteam.jvoxelizer.launcher.forge_1_12.modloader;

import com.ldtteam.jvoxelizer.modloader.IMod;
import net.minecraftforge.fml.common.ModContainer;

public class Mod implements IMod
{
    private ModContainer mod;

    private Mod(final ModContainer mod)
    {
        this.mod = mod;
    }

    @Override
    public String getModId()
    {
        return mod.getModId();
    }

    public static ModContainer asForge(final IMod mod)
    {
        if (mod instanceof ModContainer)
            return (ModContainer) mod;

        return ((Mod) mod).mod;
    }

    public static IMod fromForge(final ModContainer modContainer)
    {
        if (modContainer instanceof IMod)
            return (IMod) modContainer;

        return new Mod(modContainer);
    }
}
