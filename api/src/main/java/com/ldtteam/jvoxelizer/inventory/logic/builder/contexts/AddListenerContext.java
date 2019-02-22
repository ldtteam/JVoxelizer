package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.inventory.IContainerListener;

public class AddListenerContext {

    public AddListenerContext(IContainerListener listener) {
        this.listener = listener;
    }

    private IContainerListener listener;

    public IContainerListener getListener() {
        return listener;
    }

    public void setListener(IContainerListener listener) {
        this.listener = listener;
    }
}
