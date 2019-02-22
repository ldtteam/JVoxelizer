package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.distribution;

import com.ldtteam.jvoxelizer.util.distribution.IDistribution;
import net.minecraftforge.fml.relauncher.Side;

public class Distribution implements IDistribution {
    private Side forgeDistribution;

    public Distribution(Side forgeDistribution) {
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
}
