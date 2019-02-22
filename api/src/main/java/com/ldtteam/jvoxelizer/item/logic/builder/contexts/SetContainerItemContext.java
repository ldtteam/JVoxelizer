package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItem;

public class SetContainerItemContext {

    public SetContainerItemContext(IItem containerItem) {
        this.containerItem = containerItem;
    }

    private IItem containerItem;

    public IItem getContainerItem() {
        return containerItem;
    }

    public void setContainerItem(IItem containerItem) {
        this.containerItem = containerItem;
    }
}
