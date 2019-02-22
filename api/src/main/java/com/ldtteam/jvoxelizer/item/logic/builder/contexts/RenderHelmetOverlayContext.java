package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class RenderHelmetOverlayContext {

    public RenderHelmetOverlayContext(IItemStack stack, IPlayerEntity player, IScaledResolution resolution, float partialTicks) {
        this.stack = stack;
        this.player = player;
        this.resolution = resolution;
        this.partialTicks = partialTicks;
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

    private IScaledResolution resolution;

    public IScaledResolution getResolution() {
        return resolution;
    }

    public void setResolution(IScaledResolution resolution) {
        this.resolution = resolution;
    }

    private float partialTicks;

    public float getPartialTicks() {
        return partialTicks;
    }

    public void setPartialTicks(float partialTicks) {
        this.partialTicks = partialTicks;
    }
}
