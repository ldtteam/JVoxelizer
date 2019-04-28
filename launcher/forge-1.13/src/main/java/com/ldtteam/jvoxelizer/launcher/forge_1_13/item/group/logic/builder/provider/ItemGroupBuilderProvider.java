package com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.logic.builder.provider;

import com.ldtteam.jvoxelizer.item.group.IItemGroup;
import com.ldtteam.jvoxelizer.item.group.logic.builder.IItemGroupBuilder;
import com.ldtteam.jvoxelizer.item.group.logic.builder.IItemGroupBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.item.group.logic.builder.ItemGroupBuilder;

public class ItemGroupBuilderProvider implements IItemGroupBuilderProvider
{
    private static ItemGroupBuilderProvider ourInstance = new ItemGroupBuilderProvider();

    public static ItemGroupBuilderProvider getInstance()
    {
        return ourInstance;
    }

    private ItemGroupBuilderProvider()
    {
    }

    @Override
    public <T> IItemGroupBuilder<?, T, IItemGroup<T>> provide(final String label)
    {
        return new ItemGroupBuilder<>(label);
    }

    @Override
    public <T> IItemGroupBuilder<?, T, IItemGroup<T>> provide(final int index, final String label)
    {
        return new ItemGroupBuilder<>(index, label);
    }
}
