package com.ldtteam.jvoxelizer.launcher.forge_1_12.modloader;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.modloader.IMod;
import net.minecraftforge.fml.common.ModContainer;

public class Mod implements IMod, IForgeJVoxelizerWrapper
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

    public ModContainer getMod()
    {
        return mod;
    }

    public static ModContainer asForge(final IMod mod)
    {
        if (mod instanceof ModContainer)
        {
            return (ModContainer) mod;
        }

        if (mod == null)
        {
            return null;
        }

        if (!(mod instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("Mod is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) mod).getForgeInstance();
    }

    public static IMod fromForge(final ModContainer modContainer)
    {
        if (modContainer instanceof IMod)
        {
            return (IMod) modContainer;
        }

        return new Mod(modContainer);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getMod();
    }
}
