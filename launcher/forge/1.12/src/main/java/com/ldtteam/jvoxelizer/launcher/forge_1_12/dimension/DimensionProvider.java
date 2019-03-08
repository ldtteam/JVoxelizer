package com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.dimension.IDimensionProvider;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class DimensionProvider implements IDimensionProvider
{
    private static DimensionProvider ourInstance = new DimensionProvider();

    public static DimensionProvider getInstance()
    {
        return ourInstance;
    }

    private DimensionProvider()
    {
    }

    @Override
    public IDimension provide(final int id)
    {
        return Dimension.fromForge(FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(id));
    }
}
