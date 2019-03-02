package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiContainer;
import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.inventory.IContainer;

final class IGuiContainerBuilderProviderHolder extends AbstractHolder<IGuiContainerBuilderProvider> implements IGuiContainerBuilderProvider
{
    private static IGuiContainerBuilderProviderHolder ourInstance = new IGuiContainerBuilderProviderHolder();

    public static IGuiContainerBuilderProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IGuiContainerBuilderProviderHolder()
    {
        super(IGuiContainerBuilder.class.getName());
    }

    @Override
    public <I> IGuiContainerBuilder<?, I, IGuiContainer<I>> provide(final I instanceData, final IContainer<?> container)
    {
        return getProvider().provide(instanceData, container);
    }
}