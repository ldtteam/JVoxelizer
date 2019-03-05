package com.ldtteam.jvoxelizer.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.IInstancedObject;

/**
 * Represents a Gui in the game.
 *
 * @param <I> The type of the instance data that the UI holds, also known as the UIs context. If not known (EG external UIs, then this is {@link com.ldtteam.jvoxelizer.core.logic.DummyInstanceData}.
 */
public interface IGui<I> extends IInstancedObject<I>
{
    /**
     * Draws a horizontal line on the screen.
     *
     * @param startX The start X-Coordinate.
     * @param endX The end X-Coordinate.
     * @param y The Y-Coordinate of both the start and the end.
     * @param color The color of the line.
     */
    void drawHorizontalLine(int startX, int endX, int y, int color);

    /**
     * Draws a vertical line on the screen.
     *
     * @param x The X-Coordinate of both the start and the end.
     * @param startY The start Y-Coordinate.
     * @param endY The end Y-Coordinate.
     * @param color The color of the line.
     */
    void drawVerticalLine(int x, int startY, int endY, int color);

    void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor);

    void drawCenteredString(IFontRenderer fontRendererIn, String text, int x, int y, int color);

    void drawString(IFontRenderer fontRendererIn, String text, int x, int y, int color);

    void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height);

    void drawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV);

    void drawTexturedModalRect(int xCoord, int yCoord, ISprite textureSprite, int widthIn, int heightIn);

    IGameEngine getGameEngine();
}
