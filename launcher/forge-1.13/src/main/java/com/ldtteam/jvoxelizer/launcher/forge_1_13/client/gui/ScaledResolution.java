package com.ldtteam.jvoxelizer.launcher.forge_1_13.client.gui;

import com.ldtteam.jvoxelizer.client.gui.IScaledResolution;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import net.minecraft.client.MainWindow;

public class ScaledResolution implements IScaledResolution, IForgeJVoxelizerWrapper
{
    private MainWindow forgeScaledResolution;

    private ScaledResolution(final MainWindow forgeScaledResolution)
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
        int guiScale = (int) forgeScaledResolution.getGuiScaleFactor();
        return forgeScaledResolution.getScaleFactor(guiScale);
    }

    private MainWindow getForgeScaledResolution()
    {
        return this.forgeScaledResolution;
    }

    public static IScaledResolution fromForge(MainWindow scaledResolution)
    {
        return new ScaledResolution(scaledResolution);
    }

    public static MainWindow asForge(IScaledResolution resolution)
    {

        if (resolution == null)
        {
            return null;
        }
        if (!(resolution instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("ScaledResolution is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) resolution).getForgeInstance();
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeScaledResolution();
    }
}
