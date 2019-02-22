package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class CreateEntityContext {

    public CreateEntityContext(IDimension world, IEntity location, IItemStack itemstack) {
        this.world = world;
        this.location = location;
        this.itemstack = itemstack;
    }

    private IDimension world;

    public IDimension getWorld() {
        return world;
    }

    public void setWorld(IDimension world) {
        this.world = world;
    }

    private IEntity location;

    public IEntity getLocation() {
        return location;
    }

    public void setLocation(IEntity location) {
        this.location = location;
    }

    private IItemStack itemstack;

    public IItemStack getItemstack() {
        return itemstack;
    }

    public void setItemstack(IItemStack itemstack) {
        this.itemstack = itemstack;
    }
}
