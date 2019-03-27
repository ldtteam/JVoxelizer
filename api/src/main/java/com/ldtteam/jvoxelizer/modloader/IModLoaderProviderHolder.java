package com.ldtteam.jvoxelizer.modloader;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IModLoaderProviderHolder extends AbstractHolder<IModLoaderProvider> implements IModLoaderProvider
{
    private static IModLoaderProviderHolder ourInstance = new IModLoaderProviderHolder();

    public static IModLoaderProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IModLoaderProviderHolder()
    {
        super(IModLoader.class.getName());
    }

    @Override
    public IModLoader provide()
    {
        return getProvider().provide();
    }
}