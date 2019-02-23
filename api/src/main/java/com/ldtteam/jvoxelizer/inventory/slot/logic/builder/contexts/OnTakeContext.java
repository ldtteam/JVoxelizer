package com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class OnTakeContext {

    public OnTakeContext(IPlayerEntity thePlayer, IItemStack stack) {
        this.thePlayer = thePlayer;
        this.stack = stack;
    }

    private IPlayerEntity thePlayer;

    public IPlayerEntity getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(IPlayerEntity thePlayer) {
        this.thePlayer = thePlayer;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }
}
