package com.ldtteam.jvoxelizer.client.gui.logic.builder;

public interface IGuiContainerBuilderProvider
{

    <I> IGuiContainerBuilder<? extends AbstractGuiContainerBuilder<?,I>,I> provide(I instanceData);
}
