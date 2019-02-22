package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;

public class GetAttributeModifiersContext {

    public GetAttributeModifiersContext(IEquipmentSlot slot, IItemStack stack) {
        this.slot = slot;
        this.stack = stack;
    }

    private IEquipmentSlot slot;

    public IEquipmentSlot getSlot() {
        return slot;
    }

    public void setSlot(IEquipmentSlot slot) {
        this.slot = slot;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }
}
