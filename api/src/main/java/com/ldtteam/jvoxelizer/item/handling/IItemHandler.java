package com.ldtteam.jvoxelizer.item.handling;

import com.ldtteam.jvoxelizer.item.IItemStack;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface IItemHandler
{
    static IItemHandler createEmpty()
    {
        throw new NotImplementedException();
    }

    IItemStack getStackInSlot(int inventoryIndex);
}
