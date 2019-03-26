package com.ldtteam.jvoxelizer.item.logic.builder;

import com.ldtteam.jvoxelizer.item.IItem;

public interface IItemBuilderProvider
{
    <I> IItemBuilder<?, I, IItem<I>> provide();
}
