package com.ldtteam.jvoxelizer.inventory;

import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;

import java.util.List;

public interface IContainerProvider
{

    boolean canAddItemToSlot(ISlot slotIn, IItemStack stack, boolean stackSizeMatters);

    void computeStackSize(List<ISlot<?>> dragSlotsIn, int dragModeIn, IItemStack stack, int slotStackSize);
}
