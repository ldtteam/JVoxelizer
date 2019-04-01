package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui;

import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;

public class ScaledResolution implements IScaledResolution, IForgeJVoxelizerWrapper
{
    private net.minecraft.client.gui.ScaledResolution forgeScaledResolution;

    private ScaledResolution(final net.minecraft.client.gui.ScaledResolution forgeScaledResolution)
    {
        this.forgeScaledResolution = forgeScaledResolution;
    }

    @Override
    public int getScaledWidth()
    {
        return forgeScaledResolution.getScaledWidth();
    }

    @Override
    public int getScaledHeight()
    {
        return forgeScaledResolution.getScaledHeight();
    }

    @Override
    public int getScaleFactor()
    {
        return forgeScaledResolution.getScaleFactor();
    }

    private net.minecraft.client.gui.ScaledResolution getForgeScaledResolution()
    {
        return this.forgeScaledResolution;
    }

    public static IScaledResolution fromForge(net.minecraft.client.gui.ScaledResolution scaledResolution)
    {
        return new ScaledResolution(scaledResolution);
    }

    public static net.minecraft.client.gui.ScaledResolution asForge(IScaledResolution resolution)
    {
        if (!(resolution instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("ScaledResolution is not a wrapper");

        return ((IForgeJVoxelizerWrapper) resolution).getForgeInstance();
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeScaledResolution();
    }
}
