package com.ldtteam.jvoxelizer.inventory.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IClickType;

public class SlotClickContext {

    public SlotClickContext(int slotId, int dragType, IClickType clickTypeIn, IPlayerEntity player) {
        this.slotId = slotId;
        this.dragType = dragType;
        this.clickTypeIn = clickTypeIn;
        this.player = player;
    }

    private int slotId;

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    private int dragType;

    public int getDragType() {
        return dragType;
    }

    public void setDragType(int dragType) {
        this.dragType = dragType;
    }

    private IClickType clickTypeIn;

    public IClickType getClickTypeIn() {
        return clickTypeIn;
    }

    public void setClickTypeIn(IClickType clickTypeIn) {
        this.clickTypeIn = clickTypeIn;
    }

    private IPlayerEntity player;

    public IPlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(IPlayerEntity player) {
        this.player = player;
    }
}
