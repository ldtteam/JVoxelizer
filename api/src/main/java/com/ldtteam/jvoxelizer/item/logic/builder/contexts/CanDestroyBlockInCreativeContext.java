package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

public class CanDestroyBlockInCreativeContext {

    public CanDestroyBlockInCreativeContext(IDimension world, IBlockCoordinate pos, IItemStack stack, IPlayerEntity player) {
        this.world = world;
        this.pos = pos;
        this.stack = stack;
        this.player = player;
    }

    private IDimension world;

    public IDimension getWorld() {
        return world;
    }

    public void setWorld(IDimension world) {
        this.world = world;
    }

    private IBlockCoordinate pos;

    public IBlockCoordinate getPos() {
        return pos;
    }

    public void setPos(IBlockCoordinate pos) {
        this.pos = pos;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private IPlayerEntity player;

    public IPlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(IPlayerEntity player) {
        this.player = player;
    }
}
