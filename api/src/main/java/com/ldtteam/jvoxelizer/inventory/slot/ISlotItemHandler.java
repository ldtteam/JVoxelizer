package com.ldtteam.jvoxelizer.inventory.slot;

import com.ldtteam.jvoxelizer.item.handling.IItemHandler;

public interface ISlotItemHandler<I> extends ISlot<I>
{
    IItemHandler getHandler();
}
