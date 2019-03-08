package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.distribution;

import com.ldtteam.jvoxelizer.util.distribution.IDistribution;
import com.ldtteam.jvoxelizer.util.distribution.IDistributionProvider;
import net.minecraftforge.fml.relauncher.Side;

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
        return Distribution.fromForge(Side.CLIENT);
    }

    @Override
    public IDistribution provideServer()
    {
        return Distribution.fromForge(Side.SERVER);
    }
}
