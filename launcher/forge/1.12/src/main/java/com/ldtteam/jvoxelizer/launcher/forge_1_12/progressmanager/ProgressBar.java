package com.ldtteam.jvoxelizer.launcher.forge_1_12.progressmanager;

import com.ldtteam.jvoxelizer.progressmanager.IProgressBar;
import net.minecraftforge.fml.common.ProgressManager;

public class ProgressBar implements IProgressBar
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

    public static ProgressManager.ProgressBar asForge(final IProgressBar progressBar)
    {
        if (progressBar instanceof ProgressManager.ProgressBar)
            return (ProgressManager.ProgressBar) progressBar;

        return ((ProgressBar) progressBar).progressBar;
    }

    public static IProgressBar fromForge(final ProgressManager.ProgressBar progressBar)
    {
        if (progressBar instanceof IProgressBar)
            return (IProgressBar) progressBar;

        return new ProgressBar(progressBar);
    }
}
