package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

public class DrawSlotContext
{

    private ISlot slot;

    public DrawSlotContext(final ISlot slot) {this.slot = slot;}

    public ISlot getSlot()
    {
        return slot;
    }

    public void setSlot(final ISlot slot)
    {
        this.slot = slot;
    }
}
