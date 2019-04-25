package com.ldtteam.jvoxelizer.launcher.forge_1_13.progressmanager;

import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.progressmanager.IProgressManager;
import net.minecraftforge.fml.common.progress.ProgressBar;
import net.minecraftforge.fml.common.progress.StartupProgressManager;

public class ProgressManager implements IProgressManager, IForgeJVoxelizerWrapper
{
    private StartupProgressManager manager;

    private ProgressManager(final StartupProgressManager manager)
    {
        this.manager = manager;
    }

    private StartupProgressManager getManager()
    {
        return manager;
    }

    public static StartupProgressManager asForge(final IProgressManager manager)
    {
        if (manager instanceof StartupProgressManager)
        {
            return (StartupProgressManager) manager;
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

    public static IProgressManager fromForge(final StartupProgressManager manager)
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
