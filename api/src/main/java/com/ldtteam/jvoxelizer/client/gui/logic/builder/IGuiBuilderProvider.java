package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGui;

public interface IGuiBuilderProvider
{

    <I> IGuiBuilder<?, I, IGui<I>> provide(I instanceData);
}
