package com.ldtteam.jvoxelizer.inventory.slot.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.handling.IItemHandler;

public class IsHereContext {

    public IsHereContext(IItemHandler inv, int slotIn) {
        this.inv = inv;
        this.slotIn = slotIn;
    }

    private IItemHandler inv;

    public IItemHandler getInv() {
        return inv;
    }

    public void setInv(IItemHandler inv) {
        this.inv = inv;
    }

    private int slotIn;

    public int getSlotIn() {
        return slotIn;
    }

    public void setSlotIn(int slotIn) {
        this.slotIn = slotIn;
    }
}
