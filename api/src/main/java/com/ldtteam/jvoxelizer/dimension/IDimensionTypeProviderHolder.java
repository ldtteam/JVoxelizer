package com.ldtteam.jvoxelizer.dimension;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IDimensionTypeProviderHolder extends AbstractHolder<IDimensionTypeProvider> implements IDimensionTypeProvider
{
    private static IDimensionTypeProviderHolder ourInstance = new IDimensionTypeProviderHolder();

    public static IDimensionTypeProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IDimensionTypeProviderHolder()
    {
        super(IDimensionType.class.getName());
    }

    @Override
    public IDimensionType provideDefault()
    {
        return getProvider().provideDefault();
    }
}