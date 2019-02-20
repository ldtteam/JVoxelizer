package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class DrawHorizontalLineContext {

    public DrawHorizontalLineContext(int startX, int endX, int y, int color) {
        this.startX = startX;
        this.endX = endX;
        this.y = y;
        this.color = color;
    }

    private int startX;

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    private int endX;

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
