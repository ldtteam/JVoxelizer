package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.inventory.slot.ISlotItemHandler;

public interface ISlotItemHandlerProvider
{

    <C extends ISlotItemHandlerBuilder<C, I, O>, I, O extends ISlotItemHandler<I>> C provide();
}
