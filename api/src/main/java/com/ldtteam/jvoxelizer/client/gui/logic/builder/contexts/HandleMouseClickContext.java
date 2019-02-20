package com.ldtteam.jvoxelizer.client.gui.logic.builder.contexts;

import com.ldtteam.jvoxelizer.inventory.IClickType;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

public class HandleMouseClickContext {

    public HandleMouseClickContext(ISlot slotIn, int slotId, int mouseButton, IClickType type) {
        this.slotIn = slotIn;
        this.slotId = slotId;
        this.mouseButton = mouseButton;
        this.type = type;
    }

    private ISlot slotIn;

    public ISlot getSlotIn() {
        return slotIn;
    }

    public void setSlotIn(ISlot slotIn) {
        this.slotIn = slotIn;
    }

    private int slotId;

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    private int mouseButton;

    public int getMouseButton() {
        return mouseButton;
    }

    public void setMouseButton(int mouseButton) {
        this.mouseButton = mouseButton;
    }

    private IClickType type;

    public IClickType getType() {
        return type;
    }

    public void setType(IClickType type) {
        this.type = type;
    }
}
