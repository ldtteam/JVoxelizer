package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class GetAnimationParametersContext {

    public GetAnimationParametersContext(IItemStack stack, IDimension world, ILivingBaseEntity entity) {
        this.stack = stack;
        this.world = world;
        this.entity = entity;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private IDimension world;

    public IDimension getWorld() {
        return world;
    }

    public void setWorld(IDimension world) {
        this.world = world;
    }

    private ILivingBaseEntity entity;

    public ILivingBaseEntity getEntity() {
        return entity;
    }

    public void setEntity(ILivingBaseEntity entity) {
        this.entity = entity;
    }
}
