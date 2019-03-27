package com.ldtteam.jvoxelizer.common.capability.provider;

import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.util.facing.IFacing;

public interface ICapabilityProviderBuilder
{
    static ICapabilityProviderBuilder create()
    {
        return ICapabilityProviderBuilderProviderHolder.getInstance().provide();
    }

    ICapabilityProviderBuilder addCapability(ICapability<?> capability, IFacing facing);

    ICapabilityProvider build();
}
