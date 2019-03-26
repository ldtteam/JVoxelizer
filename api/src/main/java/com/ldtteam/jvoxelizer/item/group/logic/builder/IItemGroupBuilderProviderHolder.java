package com.ldtteam.jvoxelizer.item.group.logic.builder;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.item.group.IItemGroup;

final class IItemGroupBuilderProviderHolder extends AbstractHolder<IItemGroupBuilderProvider> implements IItemGroupBuilderProvider
{
    private static IItemGroupBuilderProviderHolder ourInstance = new IItemGroupBuilderProviderHolder();

    public static IItemGroupBuilderProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IItemGroupBuilderProviderHolder()
    {
        super(IItemGroupBuilder.class.getName());
    }

    @Override
    public <T> IItemGroupBuilder<?, T, IItemGroup<T>> provide(final String label)
    {
        return getProvider().provide(label);
    }

    @Override
    public <T> IItemGroupBuilder<?, T, IItemGroup<T>> provide(final int index, final String label)
    {
        return getProvider().provide(index, label);
    }
}