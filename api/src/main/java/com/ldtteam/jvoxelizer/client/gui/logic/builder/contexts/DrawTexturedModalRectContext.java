package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class DrawTexturedModalRectContext {

    public DrawTexturedModalRectContext(int x, int y, int textureX, int textureY, int width, int height) {
        this.x = x;
        this.y = y;
        this.textureX = textureX;
        this.textureY = textureY;
        this.width = width;
        this.height = height;
    }

    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int textureX;

    public int getTextureX() {
        return textureX;
    }

    public void setTextureX(int textureX) {
        this.textureX = textureX;
    }

    private int textureY;

    public int getTextureY() {
        return textureY;
    }

    public void setTextureY(int textureY) {
        this.textureY = textureY;
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
