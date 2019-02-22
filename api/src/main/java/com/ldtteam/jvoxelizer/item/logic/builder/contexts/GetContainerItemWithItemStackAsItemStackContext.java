package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class GetContainerItemWithItemStackAsItemStackContext {

    public GetContainerItemWithItemStackAsItemStackContext(IItemStack itemStack) {
        this.itemStack = itemStack;
    }

    private IItemStack itemStack;

    public IItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(IItemStack itemStack) {
        this.itemStack = itemStack;
    }
}
