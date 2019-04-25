package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.distribution;

import com.ldtteam.jvoxelizer.util.distribution.IDistribution;
import com.ldtteam.jvoxelizer.util.distribution.IDistributionProvider;
import net.minecraftforge.fml.LogicalSide;

public class DistributionProvider implements IDistributionProvider
{
    private static DistributionProvider ourInstance = new DistributionProvider();

    public static DistributionProvider getInstance()
    {
        return ourInstance;
    }

    private DistributionProvider()
    {
    }

    @Override
    public IDistribution provideClient()
    {
        return Distribution.fromForge(LogicalSide.CLIENT);
    }

    @Override
    public IDistribution provideServer()
    {
        return Distribution.fromForge(LogicalSide.SERVER);
    }
}
