package com.ldtteam.jvoxelizer.util.distribution;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IDistributionProviderHolder extends AbstractHolder<IDistributionProvider> implements IDistributionProvider
{
    private static IDistributionProviderHolder ourInstance = new IDistributionProviderHolder();

    public static IDistributionProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IDistributionProviderHolder()
    {
        super(IDistribution.class.getName());
    }

    @Override
    public IDistribution provideClient()
    {
        return getProvider().provideClient();
    }

    @Override
    public IDistribution provideServer()
    {
        return getProvider().provideServer();
    }
}
