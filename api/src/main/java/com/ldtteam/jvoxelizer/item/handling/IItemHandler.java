package com.ldtteam.jvoxelizer.item.handling;

import com.ldtteam.jvoxelizer.item.IItemStack;

public interface IItemHandler
{
    IItemStack getStackInSlot(int inventoryIndex);
}
