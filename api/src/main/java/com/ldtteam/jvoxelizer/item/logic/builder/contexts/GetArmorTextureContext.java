package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;

public class GetArmorTextureContext {

    public GetArmorTextureContext(IItemStack stack, IEntity entity, IEquipmentSlot slot, String type) {
        this.stack = stack;
        this.entity = entity;
        this.slot = slot;
        this.type = type;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private IEntity entity;

    public IEntity getEntity() {
        return entity;
    }

    public void setEntity(IEntity entity) {
        this.entity = entity;
    }

    private IEquipmentSlot slot;

    public IEquipmentSlot getSlot() {
        return slot;
    }

    public void setSlot(IEquipmentSlot slot) {
        this.slot = slot;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
