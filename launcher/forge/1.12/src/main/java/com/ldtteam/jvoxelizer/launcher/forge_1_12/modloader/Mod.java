package com.ldtteam.jvoxelizer.launcher.forge_1_12.modloader;

import com.ldtteam.jvoxelizer.modloader.IMod;
import net.minecraftforge.fml.common.ModContainer;

public class Mod implements IMod
{
    private ModContainer mod;

    public Mod(final ModContainer mod)
    {
        this.mod = mod;
    }

    @Override
    public String getModId()
    {
        return mod.getModId();
    }
}
