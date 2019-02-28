package com.ldtteam.jvoxelizer.launcher.forge_1_12.progressmanager;

import com.ldtteam.jvoxelizer.progressmanager.IProgressManager;

public class ProgressManager implements IProgressManager
{
    private net.minecraftforge.fml.common.ProgressManager manager;

    public ProgressManager(final net.minecraftforge.fml.common.ProgressManager manager)
    {
        this.manager = manager;
    }
}
