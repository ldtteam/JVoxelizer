package com.ldtteam.jvoxelizer.launcher.forge_1_12.progressmanager;

import com.ldtteam.jvoxelizer.progressmanager.IProgressBar;
import net.minecraftforge.fml.common.ProgressManager;

public class ProgressBar implements IProgressBar
{
    private ProgressManager.ProgressBar progressBar;

    public ProgressBar(final ProgressManager.ProgressBar progressBar)
    {
        this.progressBar = progressBar;
    }

    @Override
    public void step(final String text)
    {
        progressBar.step(text);
    }
}
