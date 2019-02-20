package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;

public class DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext {

    public DrawTexturedModalRectWithXCoordAsIntAndYCoordAsIntAndTextureSpriteAsTextureAtlasSpriteAndWidthInAsIntAndHeightInAsIntContext(int xCoord, int yCoord, ISprite textureSprite, int widthIn, int heightIn) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.textureSprite = textureSprite;
        this.widthIn = widthIn;
        this.heightIn = heightIn;
    }

    private int xCoord;

    public int getXCoord() {
        return xCoord;
    }

    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    private int yCoord;

    public int getYCoord() {
        return yCoord;
    }

    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    private ISprite textureSprite;

    public ISprite getTextureSprite() {
        return textureSprite;
    }

    public void setTextureSprite(ISprite textureSprite) {
        this.textureSprite = textureSprite;
    }

    private int widthIn;

    public int getWidthIn() {
        return widthIn;
    }

    public void setWidthIn(int widthIn) {
        this.widthIn = widthIn;
    }

    private int heightIn;

    public int getHeightIn() {
        return heightIn;
    }

    public void setHeightIn(int heightIn) {
        this.heightIn = heightIn;
    }
}
