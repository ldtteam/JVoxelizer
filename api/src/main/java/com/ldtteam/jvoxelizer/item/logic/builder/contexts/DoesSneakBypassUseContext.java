package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

public class DoesSneakBypassUseContext {

    public DoesSneakBypassUseContext(IItemStack stack, IDimensionReader world, IBlockCoordinate pos, IPlayerEntity player) {
        this.stack = stack;
        this.world = world;
        this.pos = pos;
        this.player = player;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private IDimensionReader world;

    public IDimensionReader getWorld() {
        return world;
    }

    public void setWorld(IDimensionReader world) {
        this.world = world;
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
