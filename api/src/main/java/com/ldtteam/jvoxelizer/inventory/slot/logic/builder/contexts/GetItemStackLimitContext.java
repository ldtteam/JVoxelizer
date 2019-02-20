package com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class GetItemStackLimitContext {

    public GetItemStackLimitContext(IItemStack stack) {
        this.stack = stack;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }
}
