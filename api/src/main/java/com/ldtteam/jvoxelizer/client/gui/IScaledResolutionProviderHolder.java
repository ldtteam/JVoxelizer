package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IScaledResolutionProviderHolder extends AbstractHolder<IScaledResolutionProvider> implements IScaledResolutionProvider
{
    private static IScaledResolutionProviderHolder ourInstance = new IScaledResolutionProviderHolder();

    public static IScaledResolutionProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IScaledResolutionProviderHolder()
    {
        super(IScaledResolution.class.getName());
    }

    @Override
    public IScaledResolution provide(final IGameEngine engine)
    {
        return getProvider().provide(engine);
    }
}