package com.ldtteam.jvoxelizer.item.logic.builder;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.item.IItem;

final class IItemBuilderProviderHolder extends AbstractHolder<IItemBuilderProvider> implements IItemBuilderProvider
{
    private static IItemBuilderProviderHolder ourInstance = new IItemBuilderProviderHolder();

    public static IItemBuilderProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IItemBuilderProviderHolder()
    {
        super(IItemBuilder.class.getName());
    }

    @Override
    public <I> IItemBuilder<?, I, IItem<I>> provide()
    {
        return getProvider().provide();
    }
}