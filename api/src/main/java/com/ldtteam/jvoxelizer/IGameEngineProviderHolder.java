package com.ldtteam.jvoxelizer;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IGameEngineProviderHolder extends AbstractHolder<IGameEngineProvider> implements IGameEngineProvider
{
    private static IGameEngineProviderHolder ourInstance = new IGameEngineProviderHolder();

    public static IGameEngineProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IGameEngineProviderHolder()
    {
        super(IGameEngine.class.getName());
    }

    @Override
    public IGameEngine provide()
    {
        return getProvider().provide();
    }
}
