package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui;

import com.ldtteam.jvoxelizer.IGameEngine;
import com.ldtteam.jvoxelizer.client.gui.IGui;
import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;
import com.ldtteam.jvoxelizer.client.renderer.texture.ISprite;
import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font.FontRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.texture.Sprite;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;

public class Gui implements IGui<DummyInstanceData>, IForgeJVoxelizerWrapper
{
    private final net.minecraft.client.gui.Gui forgeGui;

    protected Gui(final net.minecraft.client.gui.Gui forgeGui) {this.forgeGui = forgeGui;}

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
        forgeGui.drawTexturedModalRect(xCoord, yCoord, Sprite.asForge(textureSprite), widthIn, heightIn);
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

    private net.minecraft.client.gui.Gui getForgeGui()
    {
        return forgeGui;
    }

    public static net.minecraft.client.gui.Gui asForge(IGui<?> gui)
    {
        if (gui instanceof net.minecraft.client.gui.Gui)
        {
            return (net.minecraft.client.gui.Gui) gui;
        }

        if (gui == null)
        {
            return null;
        }

        if (!(gui instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("Gui is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) gui).getForgeInstance();
    }

    public static IGui<?> fromForge(final net.minecraft.client.gui.Gui ingameGUI)
    {
        if (ingameGUI instanceof IGui)
        {
            return (IGui<?>) ingameGUI;
        }

        return new Gui(ingameGUI);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeGui();
    }
}
