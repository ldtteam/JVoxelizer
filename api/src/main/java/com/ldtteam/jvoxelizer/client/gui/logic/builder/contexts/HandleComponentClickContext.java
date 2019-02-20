package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class HandleComponentClickContext {

    public HandleComponentClickContext(ITextComponent component) {
        this.component = component;
    }

    private ITextComponent component;

    public ITextComponent getComponent() {
        return component;
    }

    public void setComponent(ITextComponent component) {
        this.component = component;
    }
}
