package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font.FontRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture.Sprite;

public class Gui implements IGui<DummyInstanceData>
{
    private final net.minecraft.client.gui.Gui forgeGui;

    public Gui(final net.minecraft.client.gui.Gui forgeGui) {this.forgeGui = forgeGui;}

    @Override
    public void drawHorizontalLine(final int startX, final int endX, final int y, final int color)
    {
        forgeGui.drawHorizontalLine(startX, endX, y, color);
    }

    @Override
    public void drawVerticalLine(final int x, final int startY, final int endY, final int color)
    {
        forgeGui.drawVerticalLine(x, startY, endY, color);
    }

    @Override
    public void drawGradientRect(final int left, final int top, final int right, final int bottom, final int startColor, final int endColor)
    {
        forgeGui.drawGradientRect(left, top, right, bottom, startColor, endColor);
    }

    @Override
    public void drawCenteredString(final IFontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        forgeGui.drawCenteredString(FontRenderer.asForge(fontRendererIn), text, x, y, color);
    }

    @Override
    public void drawString(final IFontRenderer fontRendererIn, final String text, final int x, final int y, final int color)
    {
        forgeGui.drawString(FontRenderer.asForge(fontRendererIn), text, x, y, color);
    }

    @Override
    public void drawTexturedModalRect(final int x, final int y, final int textureX, final int textureY, final int width, final int height)
    {
        forgeGui.drawTexturedModalRect(x, y, textureX, textureY, width, height);
    }

    @Override
    public void drawTexturedModalRect(final float xCoord, final float yCoord, final int minU, final int minV, final int maxU, final int maxV)
    {
        forgeGui.drawTexturedModalRect(xCoord, yCoord, minU, minV, maxU, maxV);
    }

    @Override
    public void drawTexturedModalRect(final int xCoord, final int yCoord, final ISprite textureSprite, final int widthIn, final int heightIn)
    {
        forgeGui.drawTexturedModalRect(xCoord,yCoord, Sprite.asForge(textureSprite), widthIn, heightIn);
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

    public static net.minecraft.client.gui.Gui asForge(IGui<?> gui)
    {
        return ((Gui) gui).forgeGui;
    }

    public static IGui<?> fromForge(final net.minecraft.client.gui.Gui ingameGUI)
    {
        return new Gui(ingameGUI);
    }
}
