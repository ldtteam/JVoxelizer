package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class HandleComponentHoverContext {

    public HandleComponentHoverContext(ITextComponent component, int x, int y) {
        this.component = component;
        this.x = x;
        this.y = y;
    }

    private ITextComponent component;

    public ITextComponent getComponent() {
        return component;
    }

    public void setComponent(ITextComponent component) {
        this.component = component;
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
