package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.handling.IInventory;

public class GetSlotFromInventoryContext {

    public GetSlotFromInventoryContext(IInventory inv, int slotIn) {
        this.inv = inv;
        this.slotIn = slotIn;
    }

    private IInventory inv;

    public IInventory getInv() {
        return inv;
    }

    public void setInv(IInventory inv) {
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
