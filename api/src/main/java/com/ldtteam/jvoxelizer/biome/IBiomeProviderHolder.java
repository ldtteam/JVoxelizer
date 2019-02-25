package com.ldtteam.jvoxelizer.biome;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IBiomeProviderHolder extends AbstractHolder<IBiomeProvider> implements IBiomeProvider
{
    private static IBiomeProviderHolder ourInstance = new IBiomeProviderHolder();

    public static IBiomeProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IBiomeProviderHolder()
    {
        super(IBiome.class.getName());
    }

    @Override
    public IBiome getPlains()
    {
        return getProvider().getPlains();
    }
}