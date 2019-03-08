package com.ldtteam.jvoxelizer.dimension.logic.builder;

import com.ldtteam.jvoxelizer.dimension.IDimensionReader;

public interface IDimensionReaderBuilderProvider
{

    <I> IDimensionReaderBuilder<?, I, ? extends IDimensionReader<I>> provide();
}
