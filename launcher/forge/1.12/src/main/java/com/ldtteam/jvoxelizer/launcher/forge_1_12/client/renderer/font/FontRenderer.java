package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font;

import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;

import org.jetbrains.annotations.NotNull;

public class FontRenderer implements IFontRenderer
{

    private final net.minecraft.client.gui.FontRenderer forgeFontRenderer;

    public FontRenderer(final net.minecraft.client.gui.FontRenderer forgeFontRenderer) {this.forgeFontRenderer = forgeFontRenderer;}

    @Override
    public void drawSplitString(final String str, final int x, final int y, final int wrapWidth, final int textColor)
    {
        forgeFontRenderer.drawSplitString(str, x, y, wrapWidth, textColor);
    }

    @Override
    public String trimStringToWidth(final String substring, final int width)
    {
        return forgeFontRenderer.trimStringToWidth(substring, width);
    }

    @Override
    public String trimStringToWidth(final String contents, final int width, final boolean reverse)
    {
        return forgeFontRenderer.trimStringToWidth(contents, width, reverse);
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

    public net.minecraft.client.gui.FontRenderer getForgeFontRenderer()
    {
        return forgeFontRenderer;
    }

    public static net.minecraft.client.gui.FontRenderer asForge(@NotNull final IFontRenderer fontRenderer)
    {
        return ((FontRenderer) fontRenderer).getForgeFontRenderer();
    }

    public static FontRenderer fromForge(net.minecraft.client.gui.FontRenderer fontRenderer)
    {
        return new FontRenderer(fontRenderer);
    }
}
