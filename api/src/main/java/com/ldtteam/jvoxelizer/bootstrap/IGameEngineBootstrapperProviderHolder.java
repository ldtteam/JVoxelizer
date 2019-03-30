package com.ldtteam.jvoxelizer.bootstrap;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IGameEngineBootstrapperProviderHolder extends AbstractHolder<IGameEngineBootstrapperProvider> implements IGameEngineBootstrapperProvider
{
    private static IGameEngineBootstrapperProviderHolder ourInstance = new IGameEngineBootstrapperProviderHolder();

    public static IGameEngineBootstrapperProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IGameEngineBootstrapperProviderHolder()
    {
        super(IGameEngineBootstrapper.class.getName());
    }

    @Override
    public void bootstrap()
    {
        getProvider().bootstrap();
    }
}