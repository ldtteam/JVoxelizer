package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiButton;

public interface IGuiButtonBuilderProvider
{

    <I> IGuiButtonBuilder<?, I, IGuiButton<I>> provide(final int buttonId, final int x, final int y, final String buttonText, final I instanceData);
}
