package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class MergeItemStackContext {

    public MergeItemStackContext(IItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
        this.stack = stack;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.reverseDirection = reverseDirection;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private int startIndex;

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    private int endIndex;

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    private boolean reverseDirection;

    public boolean getReverseDirection() {
        return reverseDirection;
    }

    public void setReverseDirection(boolean reverseDirection) {
        this.reverseDirection = reverseDirection;
    }
}
