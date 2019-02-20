package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class IsPointInRegionContext {

    public IsPointInRegionContext(int rectX, int rectY, int rectWidth, int rectHeight, int pointX, int pointY) {
        this.rectX = rectX;
        this.rectY = rectY;
        this.rectWidth = rectWidth;
        this.rectHeight = rectHeight;
        this.pointX = pointX;
        this.pointY = pointY;
    }

    private int rectX;

    public int getRectX() {
        return rectX;
    }

    public void setRectX(int rectX) {
        this.rectX = rectX;
    }

    private int rectY;

    public int getRectY() {
        return rectY;
    }

    public void setRectY(int rectY) {
        this.rectY = rectY;
    }

    private int rectWidth;

    public int getRectWidth() {
        return rectWidth;
    }

    public void setRectWidth(int rectWidth) {
        this.rectWidth = rectWidth;
    }

    private int rectHeight;

    public int getRectHeight() {
        return rectHeight;
    }

    public void setRectHeight(int rectHeight) {
        this.rectHeight = rectHeight;
    }

    private int pointX;

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    private int pointY;

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }
}
