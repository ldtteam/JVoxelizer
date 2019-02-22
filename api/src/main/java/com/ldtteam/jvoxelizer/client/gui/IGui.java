package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.IInstancedObject;

public interface IGui<I> extends IInstancedObject<I>
{
    void drawHorizontalLine(int startX, int endX, int y, int color);

    void drawVerticalLine(int x, int startY, int endY, int color);

    void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor);

    void drawCenteredString(IFontRenderer fontRendererIn, String text, int x, int y, int color);

    void drawString(IFontRenderer fontRendererIn, String text, int x, int y, int color);

    void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height);

    void drawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV);

    void drawTexturedModalRect(int xCoord, int yCoord, ISprite textureSprite, int widthIn, int heightIn);
}
