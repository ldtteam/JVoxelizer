package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class SetFocusedContext {

    public SetFocusedContext(boolean hasFocusedControlIn) {
        this.hasFocusedControlIn = hasFocusedControlIn;
    }

    private boolean hasFocusedControlIn;

    public boolean getHasFocusedControlIn() {
        return hasFocusedControlIn;
    }

    public void setHasFocusedControlIn(boolean hasFocusedControlIn) {
        this.hasFocusedControlIn = hasFocusedControlIn;
    }
}
