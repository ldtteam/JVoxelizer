package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;

public class CanInteractWithContext {

    public CanInteractWithContext(IPlayerEntity playerIn) {
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
