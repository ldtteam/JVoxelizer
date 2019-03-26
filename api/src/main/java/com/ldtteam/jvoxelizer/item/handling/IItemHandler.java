package com.ldtteam.jvoxelizer.item.handling;

import com.ldtteam.jvoxelizer.item.IItemStack;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface IItemHandler
{
    static IItemHandler empty()
    {
        return IItemHandlerProviderHolder.getInstance().provideEmpty();
    }

    static IItemHandler ranged(final IItemHandler other, final int minSlot, final int maxSlotExlcuding)
    {
        return IItemHandlerProviderHolder.getInstance().provideRanged(other, minSlot, maxSlotExlcuding);
    }

    IItemStack getStackInSlot(int inventoryIndex);
}
