package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

public class SetMaxStackSizeContext {

    public SetMaxStackSizeContext(int maxStackSize) {
        this.maxStackSize = maxStackSize;
    }

    private int maxStackSize;

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public void setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
    }
}
