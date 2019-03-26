package com.ldtteam.jvoxelizer.inventory.logic.builder;

import com.ldtteam.jvoxelizer.inventory.IContainer;

public interface IContainerBuilderProvider
{

    <I> IContainerBuilder<?, I, IContainer<I>> provide();
}
