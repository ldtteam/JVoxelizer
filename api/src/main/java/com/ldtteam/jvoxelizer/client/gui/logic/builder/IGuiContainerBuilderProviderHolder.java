package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiContainer;
import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

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
    public <C extends IGuiContainerBuilder<C, I, O>, I, O extends IGuiContainer<I>> C provide(final I instanceData)
    {
        return getProvider().provide(instanceData);
    }
}