package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class DrawGradientRectContext {

    public DrawGradientRectContext(int left, int top, int right, int bottom, int startColor, int endColor) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.startColor = startColor;
        this.endColor = endColor;
    }

    private int left;

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    private int top;

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    private int right;

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    private int bottom;

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    private int startColor;

    public int getStartColor() {
        return startColor;
    }

    public void setStartColor(int startColor) {
        this.startColor = startColor;
    }

    private int endColor;

    public int getEndColor() {
        return endColor;
    }

    public void setEndColor(int endColor) {
        this.endColor = endColor;
    }
}
