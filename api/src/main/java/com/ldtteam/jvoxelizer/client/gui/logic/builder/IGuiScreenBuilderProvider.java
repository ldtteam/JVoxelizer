package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiScreen;

public interface IGuiScreenBuilderProvider
{

    <I> IGuiScreenBuilder<?, I, IGuiScreen<I>> provide(I instanceData);
}
