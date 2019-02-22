package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class OnItemUseFinishContext {

    public OnItemUseFinishContext(IItemStack stack, IDimension worldIn, ILivingBaseEntity entityLiving) {
        this.stack = stack;
        this.worldIn = worldIn;
        this.entityLiving = entityLiving;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private IDimension worldIn;

    public IDimension getWorldIn() {
        return worldIn;
    }

    public void setWorldIn(IDimension worldIn) {
        this.worldIn = worldIn;
    }

    private ILivingBaseEntity entityLiving;

    public ILivingBaseEntity getEntityLiving() {
        return entityLiving;
    }

    public void setEntityLiving(ILivingBaseEntity entityLiving) {
        this.entityLiving = entityLiving;
    }
}
