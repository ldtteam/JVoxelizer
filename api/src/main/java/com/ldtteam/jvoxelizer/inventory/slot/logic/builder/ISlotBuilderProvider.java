package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

public interface ISlotBuilderProvider
{

    <C extends ISlotBuilder<C, I, O>, I, O extends ISlot<I>> C provide(I instanceData);
}
