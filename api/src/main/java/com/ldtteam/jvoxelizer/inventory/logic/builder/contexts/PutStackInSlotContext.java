package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class PutStackInSlotContext {

    public PutStackInSlotContext(int slotID, IItemStack stack) {
        this.slotID = slotID;
        this.stack = stack;
    }

    private int slotID;

    public int getSlotID() {
        return slotID;
    }

    public void setSlotID(int slotID) {
        this.slotID = slotID;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }
}
