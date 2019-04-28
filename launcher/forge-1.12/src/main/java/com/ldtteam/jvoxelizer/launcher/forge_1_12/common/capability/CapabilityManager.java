package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability;

import com.ldtteam.jvoxelizer.common.capability.ICapabilityManager;

public class CapabilityManager implements ICapabilityManager
{
    private net.minecraftforge.common.capabilities.CapabilityManager capabilityManager;

    private CapabilityManager(final net.minecraftforge.common.capabilities.CapabilityManager capabilityManager)
    {
        this.capabilityManager = capabilityManager;
    }

    /**
     * Getter for the wrapped element.
     *
     * @return the net.minecraftforge.common.capabilities.CapabilityManager.
     */
    private net.minecraftforge.common.capabilities.CapabilityManager getForgeCapabilityManager()
    {
        return this.capabilityManager;
    }

    public static net.minecraftforge.common.capabilities.CapabilityManager asForge(ICapabilityManager manager)
    {
        return ((CapabilityManager) manager).getForgeCapabilityManager();
    }

    public static ICapabilityManager fromForge(net.minecraftforge.common.capabilities.CapabilityManager manager)
    {
        return new CapabilityManager(manager);
    }
}
