package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.equipmentslot;

import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EquipmentSlot implements IEquipmentSlot
{
    private EntityEquipmentSlot forgeEquipmentSlot;

    private EquipmentSlot(final EntityEquipmentSlot forgeEquipmentSlot)
    {
        this.forgeEquipmentSlot = forgeEquipmentSlot;
    }

    public static EntityEquipmentSlot asForge(IEquipmentSlot slot)
    {
        return ((EquipmentSlot) slot).forgeEquipmentSlot;
    }

    public static IEquipmentSlot fromForge(EntityEquipmentSlot slot)
    {
        return new EquipmentSlot(slot);
    }
}
