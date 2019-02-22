package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class GetItemToolTipContext {

    public GetItemToolTipContext(IItemStack itemStack) {
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
