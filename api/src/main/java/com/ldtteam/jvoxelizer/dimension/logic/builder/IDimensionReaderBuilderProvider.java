package com.ldtteam.jvoxelizer.dimension.logic.builder;

import com.ldtteam.jvoxelizer.dimension.IDimensionReader;

public interface IDimensionReaderBuilderProvider
{

    <C extends IDimensionReaderBuilder<C, I, O>, I, O extends IDimensionReader<I>> C provide();
}
