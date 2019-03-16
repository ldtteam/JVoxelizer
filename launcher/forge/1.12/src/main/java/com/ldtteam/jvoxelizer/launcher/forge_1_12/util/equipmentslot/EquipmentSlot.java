package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.equipmentslot;

import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EquipmentSlot implements IEquipmentSlot
{
    private EntityEquipmentSlot forgeEquipmentSlot;

    private EquipmentSlot(final EntityEquipmentSlot forgeEquipmentSlot)
    {
        this.forgeEquipmentSlot = forgeEquipmentSlot;
    }

    public static EntityEquipmentSlot asForge(IEquipmentSlot distribution)
    {
        return ((EquipmentSlot) distribution).forgeEquipmentSlot;
    }

    public static IEquipmentSlot fromForge(EntityEquipmentSlot side)
    {
        return new EquipmentSlot(side);
    }
}
