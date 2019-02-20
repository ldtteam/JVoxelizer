package com.ldtteam.jvoxelizer.client.renderer.font;

public interface IFontRenderer
{
    void drawSplitString(String str, int x, int y, int wrapWidth, int textColor);

    String trimStringToWidth(String substring, int width);

    String trimStringToWidth(String contents, int width, boolean reverse);

    int drawStringWithShadow(String text, float drawStartX, float drawStartY, int rgb);

    int getFontHeight();

    int getStringWidth(String substring);
}
