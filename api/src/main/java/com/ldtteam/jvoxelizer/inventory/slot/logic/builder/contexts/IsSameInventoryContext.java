package com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts;

import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

public class IsSameInventoryContext {

    public IsSameInventoryContext(ISlot other) {
        this.other = other;
    }

    private ISlot other;

    public ISlot getOther() {
        return other;
    }

    public void setOther(ISlot other) {
        this.other = other;
    }
}
