package com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension;

import com.ldtteam.jvoxelizer.dimension.IDimensionType;
import com.ldtteam.jvoxelizer.dimension.IDimensionTypeProvider;
import net.minecraft.world.WorldType;

public class DimensionTypeProvider implements IDimensionTypeProvider
{
    private static DimensionTypeProvider ourInstance = new DimensionTypeProvider();

    public static DimensionTypeProvider getInstance()
    {
        return ourInstance;
    }

    private DimensionTypeProvider()
    {
    }

    @Override
    public IDimensionType provideDefault()
    {
        return DimensionType.fromForge(WorldType.DEFAULT);
    }
}
