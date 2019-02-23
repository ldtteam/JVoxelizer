package com.ldtteam.jvoxelizer.inventory.logic.builder;

import com.ldtteam.jvoxelizer.inventory.IContainer;

public interface IContainerBuilderProvider
{

    <C extends IContainerBuilder<C, I, O>, I, O extends IContainer<I>> IContainerBuilder<C, I, O> provide();
}
