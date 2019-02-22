package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class IsShieldContext {

    public IsShieldContext(IItemStack stack, ILivingBaseEntity entity) {
        this.stack = stack;
        this.entity = entity;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private ILivingBaseEntity entity;

    public ILivingBaseEntity getEntity() {
        return entity;
    }

    public void setEntity(ILivingBaseEntity entity) {
        this.entity = entity;
    }
}
