package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;

public class SetCanCraftContext {

    public SetCanCraftContext(IPlayerEntity player, boolean canCraft) {
        this.player = player;
        this.canCraft = canCraft;
    }

    private IPlayerEntity player;

    public IPlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(IPlayerEntity player) {
        this.player = player;
    }

    private boolean canCraft;

    public boolean getCanCraft() {
        return canCraft;
    }

    public void setCanCraft(boolean canCraft) {
        this.canCraft = canCraft;
    }
}
