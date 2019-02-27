package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;
import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IGuiScreenBuilderProviderHolder extends AbstractHolder<IGuiScreenBuilderProvider> implements IGuiScreenBuilderProvider
{
    private static IGuiScreenBuilderProviderHolder ourInstance = new IGuiScreenBuilderProviderHolder();

    public static IGuiScreenBuilderProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IGuiScreenBuilderProviderHolder()
    {
        super(IGuiScreenBuilder.class.getName());
    }

    @Override
    public <I> IGuiScreenBuilder<?, I, IGuiScreen<I>> provide(final I instanceData)
    {
        return getProvider().provide(instanceData);
    }
}