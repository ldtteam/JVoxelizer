package com.ldtteam.jvoxelizer.client.gui.logic.builder;

import com.ldtteam.jvoxelizer.client.gui.IGuiContainer;
import com.ldtteam.jvoxelizer.inventory.IContainer;

public interface IGuiContainerBuilderProvider
{

    <C extends IGuiContainerBuilder<C, I, O>, I, O extends IGuiContainer<I>> C provide(I instanceData, final IContainer<?> container);
}
