package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class GetMaxDamageWithStackAsItemStackContext {

    public GetMaxDamageWithStackAsItemStackContext(IItemStack stack) {
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
