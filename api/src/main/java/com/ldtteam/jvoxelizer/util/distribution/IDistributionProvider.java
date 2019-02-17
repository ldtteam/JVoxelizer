package com.ldtteam.jvoxelizer.util.distribution;

public interface IDistributionProvider
{

    IDistribution provideClient();

    IDistribution provideServer();
}
