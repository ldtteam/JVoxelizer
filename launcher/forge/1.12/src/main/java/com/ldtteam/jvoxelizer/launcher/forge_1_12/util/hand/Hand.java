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

    public static EnumHand asForge(IHand hand)
    {
        return ((Hand) hand).forgeHand;
    }

    public static IHand fromForge(EnumHand hand)
    {
        return new Hand(hand);
    }
}
