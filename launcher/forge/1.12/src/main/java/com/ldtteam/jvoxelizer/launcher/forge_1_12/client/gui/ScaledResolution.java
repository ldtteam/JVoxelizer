package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.gui;

import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;

public class ScaledResolution implements IScaledResolution
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
        return ((ScaledResolution) resolution).getForgeScaledResolution();
    }
}
