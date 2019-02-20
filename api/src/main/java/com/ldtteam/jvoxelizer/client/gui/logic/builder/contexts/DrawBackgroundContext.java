package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class DrawBackgroundContext {

    public DrawBackgroundContext(int tint) {
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
