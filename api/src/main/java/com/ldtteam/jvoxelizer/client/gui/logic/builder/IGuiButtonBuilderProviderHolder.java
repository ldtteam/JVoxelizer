package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiButton;
import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IGuiButtonBuilderProviderHolder extends AbstractHolder<IGuiButtonBuilderProvider> implements IGuiButtonBuilderProvider
{
    private static IGuiButtonBuilderProviderHolder ourInstance = new IGuiButtonBuilderProviderHolder();

    public static IGuiButtonBuilderProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IGuiButtonBuilderProviderHolder()
    {
        super(IGuiButtonBuilder.class.getName());
    }

    @Override
    public <I> IGuiButtonBuilder<?, I, IGuiButton<I>> provide(
      final int buttonId, final int x, final int y, final String buttonText, final I instanceData)
    {
        return getProvider().provide(buttonId, x, y, buttonText, instanceData);
    }
}