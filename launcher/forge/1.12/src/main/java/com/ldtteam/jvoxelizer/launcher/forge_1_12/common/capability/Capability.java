package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability;

import com.ldtteam.jvoxelizer.common.capability.ICapability;

public class Capability<T> implements ICapability<T>
{
    private final net.minecraftforge.common.capabilities.Capability<?> forgeCapability;

    private Capability(final net.minecraftforge.common.capabilities.Capability<?> forgeCapability) {this.forgeCapability = forgeCapability;}

    private net.minecraftforge.common.capabilities.Capability<?> getForgeCapability()
    {
        return forgeCapability;
    }

    public static net.minecraftforge.common.capabilities.Capability<?> asForge(ICapability<?> capability)
    {
        if (capability instanceof net.minecraftforge.common.capabilities.Capability)
            return (net.minecraftforge.common.capabilities.Capability<?>) capability;

        return ((Capability<?>) capability).getForgeCapability();
    }

    public static <S> ICapability<S> fromForge(net.minecraftforge.common.capabilities.Capability<?> capability)
    {
        if (capability instanceof ICapability)
            return (ICapability<S>) capability;

        return new Capability<>(capability);
    }
}
