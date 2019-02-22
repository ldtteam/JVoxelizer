package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import com.ldtteam.jvoxelizer.IGameEngine;

public class MousePressedContext {

    public MousePressedContext(IGameEngine mc, int mouseX, int mouseY) {
        this.mc = mc;
        this.mouseX = mouseX;
        this.mouseY = mouseY;
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
}
