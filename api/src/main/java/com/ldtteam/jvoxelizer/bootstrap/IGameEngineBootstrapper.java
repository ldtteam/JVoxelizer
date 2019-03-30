package com.ldtteam.jvoxelizer.bootstrap;

public interface IGameEngineBootstrapper
{

    static void bootstrap()
    {
        IGameEngineBootstrapperProviderHolder.getInstance().bootstrap();
    }
}
