package com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension.logic.builder.provider;

import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.dimension.logic.builder.IDimensionReaderBuilder;
import com.ldtteam.jvoxelizer.dimension.logic.builder.IDimensionReaderBuilderProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension.logic.builder.DimensionReaderBuilder;

public class DimensionReaderBuilderProvider implements IDimensionReaderBuilderProvider
{
    private static DimensionReaderBuilderProvider ourInstance = new DimensionReaderBuilderProvider();

    public static DimensionReaderBuilderProvider getInstance()
    {
        return ourInstance;
    }

    private DimensionReaderBuilderProvider()
    {
    }

    @Override
    public <I> IDimensionReaderBuilder<?, I, ? extends IDimensionReader<I>> provide()
    {
        return new DimensionReaderBuilder<>();
    }
}
