package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

public class GetSlotContext {

    public GetSlotContext(int slotId) {
        this.slotId = slotId;
    }

    private int slotId;

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
}
