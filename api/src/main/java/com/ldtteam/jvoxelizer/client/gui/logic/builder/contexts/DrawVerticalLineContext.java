package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class DrawVerticalLineContext {

    public DrawVerticalLineContext(int x, int startY, int endY, int color) {
        this.x = x;
        this.startY = startY;
        this.endY = endY;
        this.color = color;
    }

    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private int startY;

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    private int endY;

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
