package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class GetHoverStateContext {

    public GetHoverStateContext(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    private boolean mouseOver;

    public boolean getMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }
}
