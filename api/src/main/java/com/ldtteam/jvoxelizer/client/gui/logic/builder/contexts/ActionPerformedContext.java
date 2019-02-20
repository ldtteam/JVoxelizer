package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class ActionPerformedContext {

    public ActionPerformedContext(GuiButton button) {
        this.button = button;
    }

    private GuiButton button;

    public GuiButton getButton() {
        return button;
    }

    public void setButton(GuiButton button) {
        this.button = button;
    }
}
