package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;

public class GetCanCraftContext {

    public GetCanCraftContext(IPlayerEntity player) {
        this.player = player;
    }

    private IPlayerEntity player;

    public IPlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(IPlayerEntity player) {
        this.player = player;
    }
}
