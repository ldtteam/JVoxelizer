package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface IScaledResolution
{
    static IScaledResolution create(IGameEngine gameEngine)
    {
        throw new NotImplementedException();
    }

    int getScaledWidth();

    int getScaledHeight();

    int getScaleFactor();
}
