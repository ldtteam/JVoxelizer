package com.ldtteam.jvoxelizer.launcher.forge_1_12.item;

import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.IItemStackProvider;

public class ItemStackProvider implements IItemStackProvider
{
    private static ItemStackProvider ourInstance = new ItemStackProvider();

    public static ItemStackProvider getInstance()
    {
        return ourInstance;
    }

    private ItemStackProvider()
    {
    }

    @Override
    public IItemStack provide()
    {
        return ItemStack.fromForge(net.minecraft.item.ItemStack.EMPTY);
    }
}
