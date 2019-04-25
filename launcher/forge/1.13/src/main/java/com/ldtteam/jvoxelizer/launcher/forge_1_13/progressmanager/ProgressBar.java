package com.ldtteam.jvoxelizer.launcher.forge_1_13.progressmanager;

import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.progressmanager.IProgressBar;

public class ProgressBar implements IProgressBar, IForgeJVoxelizerWrapper
{
    private net.minecraftforge.fml.common.progress.ProgressBar progressBar;

    private ProgressBar(final net.minecraftforge.fml.common.progress.ProgressBar progressBar)
    {
        this.progressBar = progressBar;
    }

    @Override
    public void step(final String text)
    {
        progressBar.step(text);
    }

    private net.minecraftforge.fml.common.progress.ProgressBar getProgressBar()
    {
        return progressBar;
    }

    public static net.minecraftforge.fml.common.progress.ProgressBar asForge(final IProgressBar progressBar)
    {
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

    public static IProgressBar fromForge(final net.minecraftforge.fml.common.progress.ProgressBar progressBar)
    {
        return new ProgressBar(progressBar);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getProgressBar();
    }
}
