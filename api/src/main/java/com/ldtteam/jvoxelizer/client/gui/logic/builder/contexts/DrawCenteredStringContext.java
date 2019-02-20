package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import com.ldtteam.jvoxelizer.client.renderer.font.IFontRenderer;

public class DrawCenteredStringContext {

    public DrawCenteredStringContext(IFontRenderer fontRendererIn, String text, int x, int y, int color) {
        this.fontRendererIn = fontRendererIn;
        this.text = text;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    private IFontRenderer fontRendererIn;

    public IFontRenderer getFontRendererIn() {
        return fontRendererIn;
    }

    public void setFontRendererIn(IFontRenderer fontRendererIn) {
        this.fontRendererIn = fontRendererIn;
    }

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
