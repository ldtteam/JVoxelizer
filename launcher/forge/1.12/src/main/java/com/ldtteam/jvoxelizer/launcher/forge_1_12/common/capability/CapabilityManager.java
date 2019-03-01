package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability;

import com.ldtteam.jvoxelizer.common.capability.ICapabilityManager;

public class CapabilityManager implements ICapabilityManager
{
    private net.minecraftforge.common.capabilities.CapabilityManager capabilityManager;

    public CapabilityManager(final net.minecraftforge.common.capabilities.CapabilityManager capabilityManager)
    {
        this.capabilityManager = capabilityManager;
    }

    /**
     * Getter for the wrapped element.
     * @return the net.minecraftforge.common.capabilities.CapabilityManager.
     */
    public net.minecraftforge.common.capabilities.CapabilityManager getForgeCapabilityManager()
    {
        return this.capabilityManager;
    }
}
