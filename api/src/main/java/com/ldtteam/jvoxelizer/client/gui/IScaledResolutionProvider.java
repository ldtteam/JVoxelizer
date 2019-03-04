package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;

public interface IScaledResolutionProvider
{

    IScaledResolution provide(IGameEngine engine);
}
