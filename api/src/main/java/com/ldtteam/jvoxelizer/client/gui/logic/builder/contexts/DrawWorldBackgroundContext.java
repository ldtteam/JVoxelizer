package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class DrawWorldBackgroundContext {

    public DrawWorldBackgroundContext(int tint) {
        this.tint = tint;
    }

    private int tint;

    public int getTint() {
        return tint;
    }

    public void setTint(int tint) {
        this.tint = tint;
    }
}
