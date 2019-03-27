package com.ldtteam.jvoxelizer.common.capability.provider;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class ICapabilityProviderBuilderProviderHolder extends AbstractHolder<ICapabilityProviderBuilderProvider> implements ICapabilityProviderBuilderProvider
{
    private static ICapabilityProviderBuilderProviderHolder ourInstance = new ICapabilityProviderBuilderProviderHolder();

    public static ICapabilityProviderBuilderProviderHolder getInstance()
    {
        return ourInstance;
    }

    private ICapabilityProviderBuilderProviderHolder()
    {
        super(ICapabilityProviderBuilder.class.getName());
    }

    @Override
    public ICapabilityProviderBuilder provide()
    {
        return getProvider().provide();
    }
}