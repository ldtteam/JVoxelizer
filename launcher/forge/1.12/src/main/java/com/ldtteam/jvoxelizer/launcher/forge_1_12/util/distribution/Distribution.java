package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.distribution;

import com.ldtteam.jvoxelizer.util.distribution.IDistribution;
import net.minecraftforge.fml.relauncher.Side;

public class Distribution implements IDistribution {
    private Side forgeDistribution;

    private Distribution(Side forgeDistribution) {
        this.forgeDistribution = forgeDistribution;
    }

    @Override
    public boolean isDedicatedServer() {
        return forgeDistribution.isServer();
    }

    @Override
    public boolean isClient() {
        return forgeDistribution.isClient();
    }

    /**
     * Getter to get the wrapped forge element.
     * @return the Side.
     */
    private Side getForgeSide()
    {
        return this.forgeDistribution;
    }

    public static Side asForge(IDistribution distribution)
    {
        return ((Distribution) distribution).getForgeSide();
    }

    public static IDistribution fromForge(Side side)
    {
        return new Distribution(side);
    }
}
