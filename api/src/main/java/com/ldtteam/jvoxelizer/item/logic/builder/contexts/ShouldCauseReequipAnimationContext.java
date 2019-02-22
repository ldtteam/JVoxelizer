package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;

public class ShouldCauseReequipAnimationContext {

    public ShouldCauseReequipAnimationContext(IItemStack oldStack, IItemStack newStack, boolean slotChanged) {
        this.oldStack = oldStack;
        this.newStack = newStack;
        this.slotChanged = slotChanged;
    }

    private IItemStack oldStack;

    public IItemStack getOldStack() {
        return oldStack;
    }

    public void setOldStack(IItemStack oldStack) {
        this.oldStack = oldStack;
    }

    private IItemStack newStack;

    public IItemStack getNewStack() {
        return newStack;
    }

    public void setNewStack(IItemStack newStack) {
        this.newStack = newStack;
    }

    private boolean slotChanged;

    public boolean getSlotChanged() {
        return slotChanged;
    }

    public void setSlotChanged(boolean slotChanged) {
        this.slotChanged = slotChanged;
    }
}
