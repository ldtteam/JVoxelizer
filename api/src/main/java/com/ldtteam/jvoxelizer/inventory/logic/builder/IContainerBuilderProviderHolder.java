package com.ldtteam.jvoxelizer.inventory.logic.builder;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.inventory.IContainer;

final class IContainerBuilderProviderHolder extends AbstractHolder<IContainerBuilderProvider> implements IContainerBuilderProvider
{
    private static IContainerBuilderProviderHolder ourInstance = new IContainerBuilderProviderHolder();

    public static IContainerBuilderProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IContainerBuilderProviderHolder()
    {
        super(IContainerBuilder.class.getName());
    }

    @Override
    public <I> IContainerBuilder<?, I, IContainer<I>> provide()
    {
        return getProvider().provide();
    }
}