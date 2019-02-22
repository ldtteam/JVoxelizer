package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class OnDroppedByPlayerContext {

    public OnDroppedByPlayerContext(IItemStack item, IPlayerEntity player) {
        this.item = item;
        this.player = player;
    }

    private IItemStack item;

    public IItemStack getItem() {
        return item;
    }

    public void setItem(IItemStack item) {
        this.item = item;
    }

    private IPlayerEntity player;

    public IPlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(IPlayerEntity player) {
        this.player = player;
    }
}
