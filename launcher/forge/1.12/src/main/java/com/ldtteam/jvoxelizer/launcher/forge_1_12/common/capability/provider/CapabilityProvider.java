package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability.provider;

import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.common.capability.provider.ICapabilityProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability.Capability;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.facing.Facing;
import com.ldtteam.jvoxelizer.util.facing.IFacing;

public class CapabilityProvider implements ICapabilityProvider, IForgeJVoxelizerWrapper
{
    private final net.minecraftforge.common.capabilities.ICapabilityProvider forgeCapabilityProvider;

    private CapabilityProvider(final net.minecraftforge.common.capabilities.ICapabilityProvider forgeCapabilityProvider) {this.forgeCapabilityProvider = forgeCapabilityProvider;}

    @Override
    public boolean hasCapability(final ICapability<?> capability, final IFacing facing)
    {
        return getForgeCapabilityProvider().hasCapability(Capability.asForge(capability), Facing.asForge(facing));
    }

    @Override
    public <T> T getCapability(final ICapability<T> capability, final IFacing facing)
    {
        return Capability.convertFromForgeToJVox(capability, getForgeCapabilityProvider().getCapability(Capability.asForge(capability), Facing.asForge(facing)));
    }

    private net.minecraftforge.common.capabilities.ICapabilityProvider getForgeCapabilityProvider()
    {
        return forgeCapabilityProvider;
    }

    public static net.minecraftforge.common.capabilities.ICapabilityProvider asForge(ICapabilityProvider capabilityProvider)
    {
        if (capabilityProvider instanceof net.minecraftforge.common.capabilities.ICapabilityProvider)
        {
            return (net.minecraftforge.common.capabilities.ICapabilityProvider) capabilityProvider;
        }

        if (capabilityProvider == null)
        {
            return null;
        }

        if (!(capabilityProvider instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("CapabilityProvider is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) capabilityProvider).getForgeInstance();
    }

    public static ICapabilityProvider fromForge(net.minecraftforge.common.capabilities.ICapabilityProvider capabilityProvider)
    {
        if (capabilityProvider instanceof ICapabilityProvider)
        {
            return (ICapabilityProvider) capabilityProvider;
        }

        return new CapabilityProvider(capabilityProvider);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeCapabilityProvider();
    }
}
