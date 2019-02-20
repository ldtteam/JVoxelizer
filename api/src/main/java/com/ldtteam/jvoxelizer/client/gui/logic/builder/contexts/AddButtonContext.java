package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import com.ldtteam.jvoxelizer.client.gui.IGuiButton;

public class AddButtonContext<T extends IGuiButton> {

    public AddButtonContext(T buttonIn) {
        this.buttonIn = buttonIn;
    }

    private T buttonIn;

    public T getButtonIn() {
        return buttonIn;
    }

    public void setButtonIn(T buttonIn) {
        this.buttonIn = buttonIn;
    }
}
