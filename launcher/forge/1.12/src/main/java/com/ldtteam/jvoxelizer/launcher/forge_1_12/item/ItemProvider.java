package com.ldtteam.jvoxelizer.launcher.forge_1_12.item;

import com.ldtteam.jvoxelizer.item.IItem;
import com.ldtteam.jvoxelizer.item.IItemProvider;
import net.minecraft.item.Item;

public class ItemProvider implements IItemProvider
{
    private static ItemProvider ourInstance = new ItemProvider();

    public static ItemProvider getInstance()
    {
        return ourInstance;
    }

    private ItemProvider()
    {
    }

    @Override
    public int provideIdFromItem(final IItem<?> item)
    {
        return Item.getIdFromItem(com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item.asForge(item));
    }
}
