package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory;

import com.ldtteam.jvoxelizer.inventory.IContainerListener;

public class ContainerListener implements IContainerListener
{

    private final net.minecraft.inventory.IContainerListener forgeContainerListener;

    private ContainerListener(final net.minecraft.inventory.IContainerListener forgeContainerListener) {this.forgeContainerListener = forgeContainerListener;}

    private net.minecraft.inventory.IContainerListener getForgeContainerListener()
    {
        return forgeContainerListener;
    }

    public static net.minecraft.inventory.IContainerListener asForge(IContainerListener containerListener)
    {
        if (containerListener  instanceof net.minecraft.inventory.IContainerListener)
            return (net.minecraft.inventory.IContainerListener) containerListener;

        return ((ContainerListener) containerListener).getForgeContainerListener();
    }

    public static IContainerListener fromForge(net.minecraft.inventory.IContainerListener listener)
    {
        if (listener instanceof IContainerListener)
            return (IContainerListener) listener;

        return new ContainerListener(listener);
    }
}
