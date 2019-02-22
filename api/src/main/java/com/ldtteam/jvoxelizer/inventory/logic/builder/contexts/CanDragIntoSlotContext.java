package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

public class CanDragIntoSlotContext {

    public CanDragIntoSlotContext(ISlot slotIn) {
        this.slotIn = slotIn;
    }

    private ISlot slotIn;

    public ISlot getSlotIn() {
        return slotIn;
    }

    public void setSlotIn(ISlot slotIn) {
        this.slotIn = slotIn;
    }
}
