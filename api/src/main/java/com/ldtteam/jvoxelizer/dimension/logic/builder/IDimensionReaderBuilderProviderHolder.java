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
    public <C extends IDimensionReaderBuilder<C, I, O>, I, O extends IDimensionReader<I>> C provide()
    {
        return getProvider().provide();
    }
}