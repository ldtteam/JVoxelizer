package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;

public class Gui implements IGui<DummyInstanceData>
{
    private final net.minecraft.client.gui.Gui forgeGui;

    public Gui(final net.minecraft.client.gui.Gui forgeGui) {this.forgeGui = forgeGui;}

    @Override
    public void drawHorizontalLine(final int startX, final int endX, final int y, final int color)
    {
        forgeGui.drawHorizontalLine
    }

    @Override
    public void drawVerticalLine(final int x, final int startY, final int endY, final int color)
    {

    }

    @Override
    public void drawGradientRect(final int left, final int top, final int right, final int bottom, final int startColor, final int endColor)
    {

    }

    @Override
    public void drawCenteredString(final IFontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {

    }

    @Override
    public void drawString(final IFontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {

    }

    @Override
    public void drawTexturedModalRect(final int x, final int y, final int textureX, final int textureY, final int width, final int height)
    {

    }

    @Override
    public void drawTexturedModalRect(final float xCoord, final float yCoord, final int minU, final int minV, final int maxU, final int maxV)
    {

    }

    @Override
    public void drawTexturedModalRect(final int xCoord, final int yCoord, final ISprite textureSprite, final int widthIn, final int heightIn)
    {

    }

    @Override
    public IGameEngine getGameEngine()
    {
        return IGameEngine.getInstance();
    }

    @Override
    public DummyInstanceData getInstanceData()
    {
        return new DummyInstanceData();
    }
}
