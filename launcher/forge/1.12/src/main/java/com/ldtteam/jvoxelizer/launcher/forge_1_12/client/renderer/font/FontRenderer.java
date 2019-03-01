package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.font;

import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;

public class FontRenderer implements IFontRenderer
{
    private net.minecraft.client.gui.FontRenderer fontRenderer;

    public FontRenderer(final net.minecraft.client.gui.FontRenderer fontRenderer)
    {
        this.fontRenderer = fontRenderer;
    }

    @Override
    public void drawSplitString(final String str, final int x, final int y, final int wrapWidth, final int textColor)
    {
        fontRenderer.drawSplitString(str, x, y, wrapWidth, textColor);
    }

    @Override
    public String trimStringToWidth(final String substring, final int width)
    {
        return fontRenderer.trimStringToWidth(substring, width);
    }

    @Override
    public String trimStringToWidth(final String contents, final int width, final boolean reverse)
    {
        return fontRenderer.trimStringToWidth(contents, width, reverse);
    }

    @Override
    public int drawStringWithShadow(final String text, final float drawStartX, final float drawStartY, final int rgb)
    {
        return fontRenderer.drawStringWithShadow(text, drawStartX, drawStartY, rgb);
    }

    @Override
    public int getFontHeight()
    {
        return fontRenderer.FONT_HEIGHT;
    }

    @Override
    public int getStringWidth(final String substring)
    {
        return fontRenderer.getStringWidth(substring);
    }
}
