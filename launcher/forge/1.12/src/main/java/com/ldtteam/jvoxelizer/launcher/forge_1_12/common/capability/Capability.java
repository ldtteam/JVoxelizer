package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability;

import com.ldtteam.jvoxelizer.common.capability.ICapability;

public class Capability<T> implements ICapability<T>
{

    private final net.minecraftforge.common.capabilities.Capability<?> forgeCapability;

    public Capability(final net.minecraftforge.common.capabilities.Capability<?> forgeCapability) {this.forgeCapability = forgeCapability;}

    public net.minecraftforge.common.capabilities.Capability<?> getForgeCapability()
    {
        return forgeCapability;
    }
}
