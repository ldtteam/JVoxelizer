package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class CheckHotbarKeysContext {

    public CheckHotbarKeysContext(int keyCode) {
        this.keyCode = keyCode;
    }

    private int keyCode;

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }
}
