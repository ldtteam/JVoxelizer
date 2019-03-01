package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability;

import com.ldtteam.jvoxelizer.common.capability.ICapability;

public class Capability<T> implements ICapability<T>
{

    private final net.minecraftforge.common.capabilities.Capability<T> forgeCapability;

    public Capability(final net.minecraftforge.common.capabilities.Capability<T> forgeCapability) {this.forgeCapability = forgeCapability;}

    public net.minecraftforge.common.capabilities.Capability<T> getForgeCapability()
    {
        return forgeCapability;
    }
}
