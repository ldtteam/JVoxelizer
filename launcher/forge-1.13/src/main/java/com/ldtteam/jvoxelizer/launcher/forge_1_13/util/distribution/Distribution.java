package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.distribution;

import com.ldtteam.jvoxelizer.util.distribution.IDistribution;
import net.minecraftforge.fml.LogicalSide;

public class Distribution implements IDistribution
{
    private LogicalSide forgeDistribution;

    private Distribution(LogicalSide forgeDistribution)
    {
        this.forgeDistribution = forgeDistribution;
    }

    @Override
    public boolean isDedicatedServer()
    {
        return forgeDistribution == LogicalSide.SERVER;
    }

    @Override
    public boolean isClient()
    {
        return forgeDistribution == LogicalSide.CLIENT;
    }

    /**
     * Getter to get the wrapped forge element.
     *
     * @return the Side.
     */
    private LogicalSide getForgeSide()
    {
        return this.forgeDistribution;
    }

    public static LogicalSide asForge(IDistribution distribution)
    {
        return ((Distribution) distribution).getForgeSide();
    }

    public static IDistribution fromForge(LogicalSide side)
    {
        return new Distribution(side);
    }
}
