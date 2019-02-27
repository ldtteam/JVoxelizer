package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IGuiBuilderProviderHolder extends AbstractHolder<IGuiBuilderProvider> implements IGuiBuilderProvider
{
    private static IGuiBuilderProviderHolder ourInstance = new IGuiBuilderProviderHolder();

    public static IGuiBuilderProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IGuiBuilderProviderHolder()
    {
        super(IGuiBuilder.class.getName());
    }

    @Override
    public <I> IGuiBuilder<?, I, IGui<I>> provide(final I instanceData)
    {
        return getProvider().provide(instanceData);
    }
}