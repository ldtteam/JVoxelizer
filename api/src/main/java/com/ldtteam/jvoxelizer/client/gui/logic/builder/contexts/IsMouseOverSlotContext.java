package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

public class IsMouseOverSlotContext
{

    private ISlot slot;
    private int mouseX;
    private int mouseY;

    public IsMouseOverSlotContext(final ISlot slot, final int mouseX, final int mouseY) {
        this.slot = slot;
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }

    public ISlot getSlot()
    {
        return slot;
    }

    public void setSlot(final ISlot slot)
    {
        this.slot = slot;
    }

    public int getMouseX()
    {
        return mouseX;
    }

    public void setMouseX(final int mouseX)
    {
        this.mouseX = mouseX;
    }

    public int getMouseY()
    {
        return mouseY;
    }

    public void setMouseY(final int mouseY)
    {
        this.mouseY = mouseY;
    }
}
