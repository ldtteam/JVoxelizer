package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class DrawGuiContainerBackgroundLayerContext {

    public DrawGuiContainerBackgroundLayerContext(float partialTicks, int mouseX, int mouseY) {
        this.partialTicks = partialTicks;
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }

    private float partialTicks;

    public float getPartialTicks() {
        return partialTicks;
    }

    public void setPartialTicks(float partialTicks) {
        this.partialTicks = partialTicks;
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
