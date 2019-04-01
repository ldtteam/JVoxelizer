package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font;

import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import org.jetbrains.annotations.NotNull;

public class FontRenderer implements IFontRenderer, IForgeJVoxelizerWrapper
{

    private final net.minecraft.client.gui.FontRenderer forgeFontRenderer;

    private FontRenderer(final net.minecraft.client.gui.FontRenderer forgeFontRenderer) {this.forgeFontRenderer = forgeFontRenderer;}

    @Override
    public void drawSplitString(final String str, final int x, final int y, final int wrapWidth, final int textColor)
    {
        forgeFontRenderer.drawSplitString(str, x, y, wrapWidth, textColor);
    }

    @Override
    public String trimStringToWidth(final String stringToTrim, final int width)
    {
        return forgeFontRenderer.trimStringToWidth(stringToTrim, width);
    }

    @Override
    public String trimStringToWidth(final String stringToTrim, final int width, final boolean reverse)
    {
        return forgeFontRenderer.trimStringToWidth(stringToTrim, width, reverse);
    }

    @Override
    public int drawStringWithShadow(final String text, final float drawStartX, final float drawStartY, final int rgb)
    {
        return forgeFontRenderer.drawStringWithShadow(text, drawStartX, drawStartY, rgb);
    }

    @Override
    public int getFontHeight()
    {
        return forgeFontRenderer.FONT_HEIGHT;
    }

    @Override
    public int getStringWidth(final String substring)
    {
        return forgeFontRenderer.getStringWidth(substring);
    }

    private net.minecraft.client.gui.FontRenderer getForgeFontRenderer()
    {
        return forgeFontRenderer;
    }

    public static net.minecraft.client.gui.FontRenderer asForge(@NotNull final IFontRenderer fontRenderer)
    {
        if (fontRenderer instanceof net.minecraft.client.gui.FontRenderer)
        {
            return (net.minecraft.client.gui.FontRenderer) fontRenderer;
        }

        if (fontRenderer == null)
        {
            return null;
        }

        if (!(fontRenderer instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("FontRenderer is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) fontRenderer).getForgeInstance();
    }

    public static IFontRenderer fromForge(net.minecraft.client.gui.FontRenderer fontRenderer)
    {
        if (fontRenderer instanceof IFontRenderer)
        {
            return (IFontRenderer) fontRenderer;
        }

        return new FontRenderer(fontRenderer);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeFontRenderer();
    }
}
