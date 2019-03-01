package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui;

import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;

public class ScaledResolution implements IScaledResolution
{
    private net.minecraft.client.gui.ScaledResolution resolution;

    public ScaledResolution(final net.minecraft.client.gui.ScaledResolution resolution)
    {
        this.resolution = resolution;
    }

    @Override
    public int getScaledWidth()
    {
        return resolution.getScaledWidth();
    }

    @Override
    public int getScaledHeight()
    {
        return resolution.getScaledHeight();
    }

    @Override
    public int getScaleFactor()
    {
        return resolution.getScaleFactor();
    }

    /**
     * Get the wrapped resolution.
     * @return net.minecraft.client.gui.ScaledResolution.
     */
    public net.minecraft.client.gui.ScaledResolution getForgeResolution()
    {
        return this.resolution;
    }
}
