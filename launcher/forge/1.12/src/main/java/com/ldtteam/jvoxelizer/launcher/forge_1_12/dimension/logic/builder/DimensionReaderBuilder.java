package com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.logic.builder;

import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.dimension.logic.builder.AbstractIDimensionReaderBuilder;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.JVoxDimensionReader;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.logic.pipeline.DimensionReaderBuilderPipeline;

public class DimensionReaderBuilder<I> extends AbstractIDimensionReaderBuilder<DimensionReaderBuilder<I>, I, IDimensionReader<I>>
{
    @Override
    public IDimensionReader<I> build(final I context)
    {
        return new JVoxDimensionReader<>(new DimensionReaderBuilderPipeline<>(
          GetBlockEntityPipeline,
          GetCombinedLightPipeline,
          IsAirBlockPipeline,
          GetStrongPowerPipeline,
          GetBlockStatePipeline,
          GetWorldTypePipeline,
          GetBiomePipeline,
          IsSideSolidPipeline
        ), context);
    }
}
