package com.ldtteam.jvoxelizer.item.handling.implementations;

import com.ldtteam.jvoxelizer.item.handling.IItemHandler;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface IRangedWrappedItemHandler extends IItemHandler
{
    static IRangedWrappedItemHandler create(IItemHandler other, int minSlot, int maxSlotExlcuding)
    {
        throw new NotImplementedException();
    }
}
