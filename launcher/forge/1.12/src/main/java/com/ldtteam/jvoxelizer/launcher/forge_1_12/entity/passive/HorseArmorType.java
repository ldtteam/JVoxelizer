package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.passive;

import com.ldtteam.jvoxelizer.entity.passive.IHorseArmorType;

public class HorseArmorType implements IHorseArmorType
{
    private net.minecraft.entity.passive.HorseArmorType armorType;

    public HorseArmorType(final net.minecraft.entity.passive.HorseArmorType armorType)
    {
        this.armorType = armorType;
    }

    /**
     * Getter for the wrapped armor type.
     * @return the net.minecraft.entity.passive.HorseArmorType.
     */
    public net.minecraft.entity.passive.HorseArmorType getForgeArmorType()
    {
        return this.armorType;
    }
}
