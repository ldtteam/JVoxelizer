package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class GetEntityLifespanContext {

    public GetEntityLifespanContext(IItemStack itemStack, IDimension world) {
        this.itemStack = itemStack;
        this.world = world;
    }

    private IItemStack itemStack;

    public IItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(IItemStack itemStack) {
        this.itemStack = itemStack;
    }

    private IDimension world;

    public IDimension getWorld() {
        return world;
    }

    public void setWorld(IDimension world) {
        this.world = world;
    }
}
