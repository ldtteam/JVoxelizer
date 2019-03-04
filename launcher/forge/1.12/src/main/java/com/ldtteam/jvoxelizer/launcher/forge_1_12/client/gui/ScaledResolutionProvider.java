package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;
import com.ldtteam.jvoxelizer.client.gui.IScaledResolutionProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.GameEngine;

public class ScaledResolutionProvider implements IScaledResolutionProvider
{
    private static ScaledResolutionProvider ourInstance = new ScaledResolutionProvider();

    public static ScaledResolutionProvider getInstance()
    {
        return ourInstance;
    }

    private ScaledResolutionProvider()
    {
    }

    @Override
    public IScaledResolution provide(final IGameEngine engine)
    {
        return new ScaledResolution(new net.minecraft.client.gui.ScaledResolution(GameEngine.asForge(engine)));
    }
}
