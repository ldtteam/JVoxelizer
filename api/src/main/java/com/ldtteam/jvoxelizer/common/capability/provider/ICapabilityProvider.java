package com.ldtteam.jvoxelizer.common.capability.provider;

import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.util.facing.IFacing;

/**
 * Represents an object that has capabilities.
 */
public interface ICapabilityProvider
{
    boolean hasCapability(ICapability<?> capability, IFacing facing);

    <T> T getCapability(ICapability<T> capability, IFacing facing);
}
