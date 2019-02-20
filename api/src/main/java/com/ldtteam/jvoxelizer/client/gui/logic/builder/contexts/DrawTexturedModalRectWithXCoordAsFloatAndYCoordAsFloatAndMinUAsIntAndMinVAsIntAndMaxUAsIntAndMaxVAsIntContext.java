package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext {

    public DrawTexturedModalRectWithXCoordAsFloatAndYCoordAsFloatAndMinUAsIntAndMinVAsIntAndMaxUAsIntAndMaxVAsIntContext(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.minU = minU;
        this.minV = minV;
        this.maxU = maxU;
        this.maxV = maxV;
    }

    private float xCoord;

    public float getXCoord() {
        return xCoord;
    }

    public void setXCoord(float xCoord) {
        this.xCoord = xCoord;
    }

    private float yCoord;

    public float getYCoord() {
        return yCoord;
    }

    public void setYCoord(float yCoord) {
        this.yCoord = yCoord;
    }

    private int minU;

    public int getMinU() {
        return minU;
    }

    public void setMinU(int minU) {
        this.minU = minU;
    }

    private int minV;

    public int getMinV() {
        return minV;
    }

    public void setMinV(int minV) {
        this.minV = minV;
    }

    private int maxU;

    public int getMaxU() {
        return maxU;
    }

    public void setMaxU(int maxU) {
        this.maxU = maxU;
    }

    private int maxV;

    public int getMaxV() {
        return maxV;
    }

    public void setMaxV(int maxV) {
        this.maxV = maxV;
    }
}
