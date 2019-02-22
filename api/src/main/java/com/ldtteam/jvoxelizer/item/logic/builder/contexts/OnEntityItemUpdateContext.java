package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.item.IItemStackEntity;

public class OnEntityItemUpdateContext {

    public OnEntityItemUpdateContext(IItemStackEntity entityItem) {
        this.entityItem = entityItem;
    }

    private IItemStackEntity entityItem;

    public IItemStackEntity getEntityItem() {
        return entityItem;
    }

    public void setEntityItem(IItemStackEntity entityItem) {
        this.entityItem = entityItem;
    }
}
