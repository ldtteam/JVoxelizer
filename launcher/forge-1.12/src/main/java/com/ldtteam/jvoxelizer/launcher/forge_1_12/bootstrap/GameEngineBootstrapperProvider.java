package com.ldtteam.jvoxelizer.launcher.forge_1_12.bootstrap;

import com.ldtteam.jvoxelizer.bootstrap.IGameEngineBootstrapperProvider;
import net.minecraft.init.Bootstrap;

public class GameEngineBootstrapperProvider implements IGameEngineBootstrapperProvider
{
    private static GameEngineBootstrapperProvider ourInstance = new GameEngineBootstrapperProvider();

    public static GameEngineBootstrapperProvider getInstance()
    {
        return ourInstance;
    }

    private GameEngineBootstrapperProvider()
    {
    }

    @Override
    public void bootstrap()
    {
        Bootstrap.register();
    }
}
