package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class DrawHoveringTextWithTextAsStringContext {

    public DrawHoveringTextWithTextAsStringContext(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
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
}
