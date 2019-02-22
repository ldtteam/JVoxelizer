package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class CanMergeSlotContext {

    public CanMergeSlotContext(IItemStack stack, ISlot slotIn) {
        this.stack = stack;
        this.slotIn = slotIn;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private ISlot slotIn;

    public ISlot getSlotIn() {
        return slotIn;
    }

    public void setSlotIn(ISlot slotIn) {
        this.slotIn = slotIn;
    }
}
