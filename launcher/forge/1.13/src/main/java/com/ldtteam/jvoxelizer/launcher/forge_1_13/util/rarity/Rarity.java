package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.rarity;

import com.ldtteam.jvoxelizer.util.rarity.IRarity;
import net.minecraft.item.EnumRarity;

public class Rarity implements IRarity
{
    private EnumRarity rarity;

    private Rarity(final EnumRarity rarity)
    {
        this.rarity = rarity;
    }

    @Override
    public boolean isCommon()
    {
        return rarity == EnumRarity.COMMON;
    }

    @Override
    public boolean isRare()
    {
        return rarity == EnumRarity.RARE;
    }

    @Override
    public boolean isUncommon()
    {
        return rarity == EnumRarity.UNCOMMON;
    }

    @Override
    public boolean isEpic()
    {
        return rarity == EnumRarity.EPIC;
    }

    public static EnumRarity asForge(IRarity rarity)
    {
        return ((Rarity) rarity).rarity;
    }

    public static IRarity fromForge(EnumRarity rarity)
    {
        return new Rarity(rarity);
    }
}
