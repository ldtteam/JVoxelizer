package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import java.util.List;

public class DrawHoveringTextWithTextLinesAsStringListContext {

    public DrawHoveringTextWithTextLinesAsStringListContext(List<String> textLines, int x, int y) {
        this.textLines = textLines;
        this.x = x;
        this.y = y;
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
}
