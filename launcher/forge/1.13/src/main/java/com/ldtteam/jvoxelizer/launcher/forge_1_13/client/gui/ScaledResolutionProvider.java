package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;
import com.ldtteam.jvoxelizer.client.gui.IScaledResolutionProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.GameEngine;

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
        return ScaledResolution.fromForge(GameEngine.asForge(engine).mainWindow);
    }
}
