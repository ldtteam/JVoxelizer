package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

public class OnBlockStartBreakContext {

    public OnBlockStartBreakContext(IItemStack itemstack, IBlockCoordinate pos, IPlayerEntity player) {
        this.itemstack = itemstack;
        this.pos = pos;
        this.player = player;
    }

    private IItemStack itemstack;

    public IItemStack getItemstack() {
        return itemstack;
    }

    public void setItemstack(IItemStack itemstack) {
        this.itemstack = itemstack;
    }

    private IBlockCoordinate pos;

    public IBlockCoordinate getPos() {
        return pos;
    }

    public void setPos(IBlockCoordinate pos) {
        this.pos = pos;
    }

    private IPlayerEntity player;

    public IPlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(IPlayerEntity player) {
        this.player = player;
    }
}
