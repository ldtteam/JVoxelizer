package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import com.ldtteam.jvoxelizer.IGameEngine;

public class OnResizeContext {

    public OnResizeContext(IGameEngine mcIn, int w, int h) {
        this.mcIn = mcIn;
        this.w = w;
        this.h = h;
    }

    private IGameEngine mcIn;

    public IGameEngine getMcIn() {
        return mcIn;
    }

    public void setMcIn(IGameEngine mcIn) {
        this.mcIn = mcIn;
    }

    private int w;

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    private int h;

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
