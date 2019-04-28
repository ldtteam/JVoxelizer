package com.ldtteam.jvoxelizer.launcher.forge_1_13;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.IGameEngineProvider;
import net.minecraft.client.Minecraft;

public class GameEngineProvider implements IGameEngineProvider
{
    private static GameEngineProvider ourInstance = new GameEngineProvider();

    public static GameEngineProvider getInstance()
    {
        return ourInstance;
    }

    private GameEngineProvider()
    {
    }

    @Override
    public IGameEngine provide()
    {
        return GameEngine.fromForge(Minecraft.getInstance());
    }
}
