package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

public class ConfirmClickedContext {

    public ConfirmClickedContext(boolean result, int id) {
        this.result = result;
        this.id = id;
    }

    private boolean result;

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
