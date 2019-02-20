package com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.player.IPlayerEntity;

public class CanTakeStackContext {

    public CanTakeStackContext(IPlayerEntity playerIn) {
        this.playerIn = playerIn;
    }

    private IPlayerEntity playerIn;

    public IPlayerEntity getPlayerIn() {
        return playerIn;
    }

    public void setPlayerIn(IPlayerEntity playerIn) {
        this.playerIn = playerIn;
    }
}
