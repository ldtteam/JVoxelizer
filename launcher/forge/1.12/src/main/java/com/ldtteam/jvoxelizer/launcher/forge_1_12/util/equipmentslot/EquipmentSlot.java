package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.equipmentslot;

import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;

public class EquipmentSlot implements IEquipmentSlot
{
    private EquipmentSlot forgeEquipmentSlot;

    public EquipmentSlot(final EquipmentSlot forgeEquipmentSlot)
    {
        this.forgeEquipmentSlot = forgeEquipmentSlot;
    }
}
