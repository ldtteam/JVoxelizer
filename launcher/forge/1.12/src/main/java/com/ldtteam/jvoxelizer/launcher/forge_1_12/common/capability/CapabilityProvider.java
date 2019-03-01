package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability;

import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.common.capability.ICapabilityProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.facing.Facing;
import com.ldtteam.jvoxelizer.util.facing.IFacing;

public class CapabilityProvider implements ICapabilityProvider
{
    private net.minecraftforge.common.capabilities.ICapabilityProvider provider;

    public CapabilityProvider(final net.minecraftforge.common.capabilities.ICapabilityProvider provider)
    {
        this.provider = provider;
    }

    @Override
    public boolean hasCapability(final ICapability<?> capability, final IFacing facing)
    {
        return provider.hasCapability(((Capability)capability).getForgeCapability(), ((Facing)facing).getForgeSide());
    }

    @Override
    public <T> T getCapability(final ICapability<T> capability, final IFacing facing)
    {
        return new Capability(provider.getCapability(((Capability)capability).getForgeCapability(), ((Facing)facing).getForgeSide()));
    }
}
