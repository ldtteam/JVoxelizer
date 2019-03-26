package com.ldtteam.jvoxelizer.item.group.logic.builder;

import com.ldtteam.jvoxelizer.item.group.IItemGroup;

public interface IItemGroupBuilderProvider
{
    <T> IItemGroupBuilder<?, T, IItemGroup<T>> provide(String label);

    <T> IItemGroupBuilder<?, T, IItemGroup<T>> provide(int index, String label);
}
