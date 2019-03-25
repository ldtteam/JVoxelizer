package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.handling.IInventory;

public interface ISlotBuilderProvider
{

    <I> ISlotBuilder<?, I, ISlot<I>> provide(final IInventory inventory, final int index, final int x, final int y, I instanceData);
}
