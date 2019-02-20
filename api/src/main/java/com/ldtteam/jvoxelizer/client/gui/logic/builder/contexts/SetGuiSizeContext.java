package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class SetGuiSizeContext {

    public SetGuiSizeContext(int w, int h) {
        this.w = w;
        this.h = h;
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
