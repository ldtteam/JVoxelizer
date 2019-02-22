package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;

public class GetItemAttributeModifiersContext {

    public GetItemAttributeModifiersContext(IEquipmentSlot equipmentSlot) {
        this.equipmentSlot = equipmentSlot;
    }

    private IEquipmentSlot equipmentSlot;

    public IEquipmentSlot getEquipmentSlot() {
        return equipmentSlot;
    }

    public void setEquipmentSlot(IEquipmentSlot equipmentSlot) {
        this.equipmentSlot = equipmentSlot;
    }
}
