package com.ldtteam.jvoxelizer.launcher.forge_1_12.progressmanager;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.progressmanager.IProgressManager;

public class ProgressManager implements IProgressManager, IForgeJVoxelizerWrapper
{
    private net.minecraftforge.fml.common.ProgressManager manager;

    private ProgressManager(final net.minecraftforge.fml.common.ProgressManager manager)
    {
        this.manager = manager;
    }

    private net.minecraftforge.fml.common.ProgressManager getManager()
    {
        return manager;
    }

    public static net.minecraftforge.fml.common.ProgressManager asForge(final IProgressManager manager)
    {
        if (manager instanceof net.minecraftforge.fml.common.ProgressManager)
        {
            return (net.minecraftforge.fml.common.ProgressManager) manager;
        }

        if (manager == null)
        {
            return null;
        }

        if (!(manager instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("ProgressManager is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) manager).getForgeInstance();
    }

    public static IProgressManager fromForge(final net.minecraftforge.fml.common.ProgressManager manager)
    {
        if (manager instanceof IProgressManager)
        {
            return (IProgressManager) manager;
        }

        return new ProgressManager(manager);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getManager();
    }
}
