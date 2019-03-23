package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.passive;

import com.ldtteam.jvoxelizer.entity.passive.IHorseArmorType;

public class HorseArmorType implements IHorseArmorType
{
    private net.minecraft.entity.passive.HorseArmorType armorType;

    private HorseArmorType(final net.minecraft.entity.passive.HorseArmorType armorType)
    {
        this.armorType = armorType;
    }

    private net.minecraft.entity.passive.HorseArmorType getForgeArmorType()
    {
        return this.armorType;
    }

    public static net.minecraft.entity.passive.HorseArmorType asForge(IHorseArmorType armorType)
    {
        return ((HorseArmorType) armorType).getForgeArmorType();
    }

    public static IHorseArmorType fromForge(net.minecraft.entity.passive.HorseArmorType armorType)
    {
        return new HorseArmorType(armorType);
    }
}
