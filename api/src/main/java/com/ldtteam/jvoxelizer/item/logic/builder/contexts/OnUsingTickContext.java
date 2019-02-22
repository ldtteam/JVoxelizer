package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class OnUsingTickContext {

    public OnUsingTickContext(IItemStack stack, ILivingBaseEntity player, int count) {
        this.stack = stack;
        this.player = player;
        this.count = count;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private ILivingBaseEntity player;

    public ILivingBaseEntity getPlayer() {
        return player;
    }

    public void setPlayer(ILivingBaseEntity player) {
        this.player = player;
    }

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
