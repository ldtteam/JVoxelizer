package com.ldtteam.jvoxelizer.launcher.forge_1_12.progressmanager;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.progressmanager.IProgressBar;
import net.minecraftforge.fml.common.ProgressManager;

public class ProgressBar implements IProgressBar, IForgeJVoxelizerWrapper
{
    private ProgressManager.ProgressBar progressBar;

    private ProgressBar(final ProgressManager.ProgressBar progressBar)
    {
        this.progressBar = progressBar;
    }

    @Override
    public void step(final String text)
    {
        progressBar.step(text);
    }

    private ProgressManager.ProgressBar getProgressBar()
    {
        return progressBar;
    }

    public static ProgressManager.ProgressBar asForge(final IProgressBar progressBar)
    {
        if (progressBar instanceof ProgressManager.ProgressBar)
        {
            return (ProgressManager.ProgressBar) progressBar;
        }

        if (progressBar == null)
        {
            return null;
        }

        if (!(progressBar instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("ProgressBar is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) progressBar).getForgeInstance();
    }

    public static IProgressBar fromForge(final ProgressManager.ProgressBar progressBar)
    {
        if (progressBar instanceof IProgressBar)
        {
            return (IProgressBar) progressBar;
        }

        return new ProgressBar(progressBar);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getProgressBar();
    }
}
