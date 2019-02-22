package com.ldtteam.jvoxelizer.inventory;

import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.handling.IInventory;

public interface IInventoryCrafting extends IInventory
{
    IItemStack getStackInRowAndColumn(int row, int column);

    int getHeight();

    int getWidth();
}
