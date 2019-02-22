package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class OnEntitySwingContext {

    public OnEntitySwingContext(ILivingBaseEntity entityLiving, IItemStack stack) {
        this.entityLiving = entityLiving;
        this.stack = stack;
    }

    private ILivingBaseEntity entityLiving;

    public ILivingBaseEntity getEntityLiving() {
        return entityLiving;
    }

    public void setEntityLiving(ILivingBaseEntity entityLiving) {
        this.entityLiving = entityLiving;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }
}
