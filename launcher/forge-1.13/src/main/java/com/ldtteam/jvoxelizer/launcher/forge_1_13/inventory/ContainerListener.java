package com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory;

import com.ldtteam.jvoxelizer.inventory.IContainerListener;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;

public class ContainerListener implements IContainerListener, IForgeJVoxelizerWrapper
{

    private final net.minecraft.inventory.IContainerListener forgeContainerListener;

    private ContainerListener(final net.minecraft.inventory.IContainerListener forgeContainerListener) {this.forgeContainerListener = forgeContainerListener;}

    private net.minecraft.inventory.IContainerListener getForgeContainerListener()
    {
        return forgeContainerListener;
    }

    public static net.minecraft.inventory.IContainerListener asForge(IContainerListener containerListener)
    {
        if (containerListener instanceof net.minecraft.inventory.IContainerListener)
        {
            return (net.minecraft.inventory.IContainerListener) containerListener;
        }

        if (containerListener == null)
        {
            return null;
        }

        if (!(containerListener instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("ContainerListener is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) containerListener).getForgeInstance();
    }

    public static IContainerListener fromForge(net.minecraft.inventory.IContainerListener listener)
    {
        if (listener instanceof IContainerListener)
        {
            return (IContainerListener) listener;
        }

        return new ContainerListener(listener);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeContainerListener();
    }
}
