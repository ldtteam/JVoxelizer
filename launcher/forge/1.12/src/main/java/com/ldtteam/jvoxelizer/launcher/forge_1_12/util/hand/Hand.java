package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.hand;

import com.ldtteam.jvoxelizer.util.hand.IHand;
import net.minecraft.util.EnumHand;

public class Hand implements IHand
{
    private EnumHand forgeHand;

    private Hand(final EnumHand forgeHand)
    {
        this.forgeHand = forgeHand;
    }

    @Override
    public boolean isMain()
    {
        return forgeHand == EnumHand.MAIN_HAND;
    }

    @Override
    public boolean isOffHand()
    {
        return forgeHand == EnumHand.OFF_HAND;
    }

    public static EnumHand asForge(IHand distribution)
    {
        return ((Hand) distribution).forgeHand;
    }

    public static IHand fromForge(EnumHand side)
    {
        return new Hand(side);
    }
}
