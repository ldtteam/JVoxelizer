package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.hand;

import com.ldtteam.jvoxelizer.util.hand.IHand;
import net.minecraft.util.EnumHand;

public class Hand implements IHand
{
    private EnumHand forgeHand;

    public Hand(final EnumHand forgeHand)
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

    /**
     * Get the wrapped enum.
     * @return the EnumHand.
     */
    public EnumHand getForgeHand()
    {
        return this.forgeHand;
    }
}
