package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import com.ldtteam.jvoxelizer.client.gui.IGuiButton;

public class ActionPerformedContext {

    public ActionPerformedContext(IGuiButton button) {
        this.button = button;
    }

    private IGuiButton button;

    public IGuiButton getButton() {
        return button;
    }

    public void setButton(IGuiButton button) {
        this.button = button;
    }
}
