package com.ldtteam.jvoxelizer.launcher.forge_1_13.item.logic.builder.provider;

import com.ldtteam.jvoxelizer.item.IItem;
import com.ldtteam.jvoxelizer.item.logic.builder.IItemBuilder;
import com.ldtteam.jvoxelizer.item.logic.builder.IItemBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.item.logic.builder.ItemBuilder;

public class ItemBuilderProvider implements IItemBuilderProvider
{
    private static ItemBuilderProvider ourInstance = new ItemBuilderProvider();

    public static ItemBuilderProvider getInstance()
    {
        return ourInstance;
    }

    private ItemBuilderProvider()
    {
    }

    @Override
    public <I> IItemBuilder<?, I, IItem<I>> provide()
    {
        return new ItemBuilder<>();
    }
}
