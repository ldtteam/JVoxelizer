package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class DrawHoveringTextWithFontAsFontRendererContext {

    public DrawHoveringTextWithFontAsFontRendererContext(List<String> textLines, int x, int y, FontRenderer font) {
        this.textLines = textLines;
        this.x = x;
        this.y = y;
        this.font = font;
    }

    private List<String> textLines;

    public List<String> getTextLines() {
        return textLines;
    }

    public void setTextLines(List<String> textLines) {
        this.textLines = textLines;
    }

    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private FontRenderer font;

    public FontRenderer getFont() {
        return font;
    }

    public void setFont(FontRenderer font) {
        this.font = font;
    }
}
