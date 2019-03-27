package com.ldtteam.jvoxelizer.launcher.forge_1_12.progressmanager;

import com.ldtteam.jvoxelizer.progressmanager.IProgressBar;
import com.ldtteam.jvoxelizer.progressmanager.IProgressManagerProvider;
import net.minecraftforge.fml.common.ProgressManager;

public class ProgressManagerProvider implements IProgressManagerProvider
{
    private static ProgressManagerProvider ourInstance = new ProgressManagerProvider();

    public static ProgressManagerProvider getInstance()
    {
        return ourInstance;
    }

    private ProgressManagerProvider()
    {
    }

    @Override
    public IProgressBar push(final String name, final int size)
    {
        return ProgressBar.fromForge(ProgressManager.push(name, size));
    }

    @Override
    public void pop(final IProgressBar bar)
    {
        ProgressManager.pop(ProgressBar.asForge(bar));
    }
}
