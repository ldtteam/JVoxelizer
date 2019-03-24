package com.ldtteam.jvoxelizer.dimension.logic.builder;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;

final class IDimensionReaderBuilderProviderHolder extends AbstractHolder<IDimensionReaderBuilderProvider> implements IDimensionReaderBuilderProvider
{
    private static IDimensionReaderBuilderProviderHolder ourInstance = new IDimensionReaderBuilderProviderHolder();

    public static IDimensionReaderBuilderProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IDimensionReaderBuilderProviderHolder()
    {
        super(IDimensionReaderBuilder.class.getName());
    }

    @Override
    public <I> IDimensionReaderBuilder<?, I, ? extends IDimensionReader<I>> provide()
    {
        return getProvider().provide();
    }
}