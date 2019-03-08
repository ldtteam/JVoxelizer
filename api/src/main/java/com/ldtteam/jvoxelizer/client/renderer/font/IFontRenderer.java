package com.ldtteam.jvoxelizer.client.renderer.font;

/**
 * Renderer for rendering a Font.
 */
public interface IFontRenderer
{
    /**
     * Draws the given string, with a max width.
     * Splitting the string if exceeding this max width into multiple lines.
     *
     * @param str The string.
     * @param x The x-coordinate of the upper left corner.
     * @param y The y-coordinate of the upper left corner.
     * @param wrapWidth The max width
     * @param textColor The color of the text.
     */
    void drawSplitString(String str, int x, int y, int wrapWidth, int textColor);

    /**
     * Trims a given string to a given width.
     *
     * @param stringToTrim The string to trim
     * @param width The width to trim to
     * @return The trimmed string
     */
    String trimStringToWidth(String stringToTrim, int width);

    /**
     * Trims a given string to a given width from the end of the string, if required.
     *
     * @param stringToTrim The string to trim.
     * @param width The width to trim to
     * @param reverse True to start at the end, false to start at the beginning.
     * @return The trimmed string.
     */
    String trimStringToWidth(String stringToTrim, int width, boolean reverse);

    /**
     * Draws a given string from a given coordinate with a color and a string.
     *
     * @param text The string to draw.
     * @param drawStartX The x-coordinate of the upper left coordinate.
     * @param drawStartY The y-coordinate ot the upper left coordinate.
     * @param rgb The color of the string to render.
     * @return The x-coordinate of the lower left coordinate.
     */
    int drawStringWithShadow(String text, float drawStartX, float drawStartY, int rgb);

    /**
     * The height of each line.
     *
     * @return The height of the line.
     */
    int getFontHeight();

    /**
     * Calculates the width a given string would have if rendered in pixels.
     *
     * @param substring The string to calculate.
     * @return The width of the string in pixels.
     */
    int getStringWidth(String substring);
}
