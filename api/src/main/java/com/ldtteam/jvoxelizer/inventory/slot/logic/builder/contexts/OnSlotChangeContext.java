package com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class OnSlotChangeContext {

    public OnSlotChangeContext(IItemStack oldStack, IItemStack newStack) {
        this.oldStack = oldStack;
        this.newStack = newStack;
    }

    private IItemStack oldStack;

    public IItemStack getOldStack() {
        return oldStack;
    }

    public void setOldStack(IItemStack oldStack) {
        this.oldStack = oldStack;
    }

    private IItemStack newStack;

    public IItemStack getNewStack() {
        return newStack;
    }

    public void setNewStack(IItemStack newStack) {
        this.newStack = newStack;
    }
}
