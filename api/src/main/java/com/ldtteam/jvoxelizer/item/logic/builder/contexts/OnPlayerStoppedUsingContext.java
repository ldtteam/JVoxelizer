package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class OnPlayerStoppedUsingContext {

    public OnPlayerStoppedUsingContext(IItemStack stack, IDimension worldIn, ILivingBaseEntity entityLiving, int timeLeft) {
        this.stack = stack;
        this.worldIn = worldIn;
        this.entityLiving = entityLiving;
        this.timeLeft = timeLeft;
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

    private int timeLeft;

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }
}
