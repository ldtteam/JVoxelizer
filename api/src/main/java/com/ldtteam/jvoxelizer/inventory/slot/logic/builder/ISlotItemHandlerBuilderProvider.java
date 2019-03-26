package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.inventory.slot.ISlotItemHandler;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;

public interface ISlotItemHandlerBuilderProvider
{

    <I> ISlotItemHandlerBuilder<?, I, ISlotItemHandler<I>> provide(final IItemHandler inventory, final int index, final int x, final int y, I instanceData);
}
