package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.equipmentslot;

import com.ldtteam.jvoxelizer.util.equipmentslot.IEquipmentSlot;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EquipmentSlot implements IEquipmentSlot
{
    private EntityEquipmentSlot forgeEquipmentSlot;

    public EquipmentSlot(final EntityEquipmentSlot forgeEquipmentSlot)
    {
        this.forgeEquipmentSlot = forgeEquipmentSlot;
    }

    /**
     * Getter for the wrapped forge equipment slot.
     * @return EquipmentSlot.
     */
    public EntityEquipmentSlot getForgeEquipmentSlot()
    {
        return this.forgeEquipmentSlot;
    }
}
