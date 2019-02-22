package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class OnArmorTickContext {

    public OnArmorTickContext(IDimension world, IPlayerEntity player, IItemStack itemStack) {
        this.world = world;
        this.player = player;
        this.itemStack = itemStack;
    }

    private IDimension world;

    public IDimension getWorld() {
        return world;
    }

    public void setWorld(IDimension world) {
        this.world = world;
    }

    private IPlayerEntity player;

    public IPlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(IPlayerEntity player) {
        this.player = player;
    }

    private IItemStack itemStack;

    public IItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(IItemStack itemStack) {
        this.itemStack = itemStack;
    }
}
