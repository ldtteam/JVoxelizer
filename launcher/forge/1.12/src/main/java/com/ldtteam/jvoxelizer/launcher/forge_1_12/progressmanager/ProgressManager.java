package com.ldtteam.jvoxelizer.launcher.forge_1_12.progressmanager;

import com.ldtteam.jvoxelizer.progressmanager.IProgressManager;

public class ProgressManager implements IProgressManager
{
    private net.minecraftforge.fml.common.ProgressManager manager;

    private ProgressManager(final net.minecraftforge.fml.common.ProgressManager manager)
    {
        this.manager = manager;
    }

    public static net.minecraftforge.fml.common.ProgressManager asForge(final IProgressManager manager)
    {
        if (manager instanceof net.minecraftforge.fml.common.ProgressManager)
            return (net.minecraftforge.fml.common.ProgressManager) manager;

        return ((ProgressManager) manager).manager;
    }

    public static IProgressManager fromForge(final net.minecraftforge.fml.common.ProgressManager manager)
    {
        if (manager instanceof IProgressManager)
            return (IProgressManager) manager;

        return new ProgressManager(manager);
    }
}
