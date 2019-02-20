package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class SetWorldAndResolutionContext {

    public SetWorldAndResolutionContext(Minecraft mc, int width, int height) {
        this.mc = mc;
        this.width = width;
        this.height = height;
    }

    private Minecraft mc;

    public Minecraft getMc() {
        return mc;
    }

    public void setMc(Minecraft mc) {
        this.mc = mc;
    }

    private int width;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
