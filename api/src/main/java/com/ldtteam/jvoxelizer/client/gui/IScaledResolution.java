package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface IScaledResolution
{
    static IScaledResolution create(IGameEngine gameEngine)
    {
        return IScaledResolutionProviderHolder.getInstance().provide(gameEngine);
    }

    int getScaledWidth();

    int getScaledHeight();

    int getScaleFactor();
}
