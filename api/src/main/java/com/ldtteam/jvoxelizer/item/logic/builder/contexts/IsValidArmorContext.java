package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;

public class IsValidArmorContext {

    public IsValidArmorContext(IItemStack stack, IEquipmentSlot armorType, IEntity entity) {
        this.stack = stack;
        this.armorType = armorType;
        this.entity = entity;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private IEquipmentSlot armorType;

    public IEquipmentSlot getArmorType() {
        return armorType;
    }

    public void setArmorType(IEquipmentSlot armorType) {
        this.armorType = armorType;
    }

    private IEntity entity;

    public IEntity getEntity() {
        return entity;
    }

    public void setEntity(IEntity entity) {
        this.entity = entity;
    }
}
