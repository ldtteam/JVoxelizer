package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class MouseClickMoveContext {

    public MouseClickMoveContext(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        this.clickedMouseButton = clickedMouseButton;
        this.timeSinceLastClick = timeSinceLastClick;
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

    private int clickedMouseButton;

    public int getClickedMouseButton() {
        return clickedMouseButton;
    }

    public void setClickedMouseButton(int clickedMouseButton) {
        this.clickedMouseButton = clickedMouseButton;
    }

    private long timeSinceLastClick;

    public long getTimeSinceLastClick() {
        return timeSinceLastClick;
    }

    public void setTimeSinceLastClick(long timeSinceLastClick) {
        this.timeSinceLastClick = timeSinceLastClick;
    }
}
