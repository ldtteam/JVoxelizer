package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiContainer;
import com.ldtteam.jvoxelizer.inventory.IContainer;

public interface IGuiContainerBuilderProvider
{

    <I> IGuiContainerBuilder<?, I, IGuiContainer<I>> provide(I instanceData, final IContainer<?> container);
}
