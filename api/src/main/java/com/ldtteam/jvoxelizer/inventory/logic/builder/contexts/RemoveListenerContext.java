package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.inventory.IContainerListener;

public class RemoveListenerContext {

    public RemoveListenerContext(IContainerListener listener) {
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
