package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class MouseReleasedContext {

    public MouseReleasedContext(int mouseX, int mouseY, int state) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.state = state;
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

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
