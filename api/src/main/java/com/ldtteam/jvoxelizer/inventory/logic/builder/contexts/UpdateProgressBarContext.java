package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

public class UpdateProgressBarContext {

    public UpdateProgressBarContext(int id, int data) {
        this.id = id;
        this.data = data;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
