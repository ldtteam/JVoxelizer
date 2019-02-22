package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import com.ldtteam.jvoxelizer.IGameEngine;

public class DrawButtonContext {

    public DrawButtonContext(IGameEngine mc, int mouseX, int mouseY, float partialTicks) {
        this.mc = mc;
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.partialTicks = partialTicks;
    }

    private IGameEngine mc;

    public IGameEngine getMc() {
        return mc;
    }

    public void setMc(IGameEngine mc) {
        this.mc = mc;
    }

    private int mouseX;

    public int getMouseX() {
        return mouseX;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    private int mouseY;

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    private float partialTicks;

    public float getPartialTicks() {
        return partialTicks;
    }

    public void setPartialTicks(float partialTicks) {
        this.partialTicks = partialTicks;
    }
}
