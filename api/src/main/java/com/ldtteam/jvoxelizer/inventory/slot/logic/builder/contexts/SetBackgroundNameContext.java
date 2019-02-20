package com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts;

public class SetBackgroundNameContext {

    public SetBackgroundNameContext(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
