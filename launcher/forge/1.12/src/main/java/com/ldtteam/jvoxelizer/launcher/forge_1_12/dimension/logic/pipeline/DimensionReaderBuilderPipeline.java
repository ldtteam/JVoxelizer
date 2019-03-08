package com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.logic.pipeline;

import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.dimension.IDimensionType;
import com.ldtteam.jvoxelizer.dimension.logic.builder.contexts.*;

import java.util.List;
import java.util.function.Function;

public class DimensionReaderBuilderPipeline<O extends IDimensionReader<I>, I>
{
        private final List<Function<TypedPipelineElementContext<GetBlockEntityContext, IBlockEntity, O, I>, IBlockEntity>> GetBlockEntityPipeline;

        private final List<Function<TypedPipelineElementContext<GetCombinedLightContext, Integer, O, I>, Integer>> GetCombinedLightPipeline;

        private final List<Function<TypedPipelineElementContext<IsAirBlockContext, Boolean, O, I>, Boolean>> IsAirBlockPipeline;

        private final List<Function<TypedPipelineElementContext<GetStrongPowerContext, Integer, O, I>, Integer>> GetStrongPowerPipeline;

        private final List<Function<TypedPipelineElementContext<GetBlockStateContext, IBlockState, O, I>, IBlockState>> GetBlockStatePipeline;

        private final List<Function<TypedPipelineElementContext<GetWorldTypeContext, IDimensionType, O, I>, IDimensionType>> GetWorldTypePipeline;

        private final List<Function<TypedPipelineElementContext<GetBiomeContext, IBiome, O, I>, IBiome>> GetBiomePipeline;

        private final List<Function<TypedPipelineElementContext<IsSideSolidContext, Boolean, O, I>, Boolean>> IsSideSolidPipeline;

    public DimensionReaderBuilderPipeline(
      final List<Function<TypedPipelineElementContext<GetBlockEntityContext, IBlockEntity, O, I>, IBlockEntity>> getBlockEntityPipeline,
      final List<Function<TypedPipelineElementContext<GetCombinedLightContext, Integer, O, I>, Integer>> getCombinedLightPipeline,
      final List<Function<TypedPipelineElementContext<IsAirBlockContext, Boolean, O, I>, Boolean>> isAirBlockPipeline,
      final List<Function<TypedPipelineElementContext<GetStrongPowerContext, Integer, O, I>, Integer>> getStrongPowerPipeline,
      final List<Function<TypedPipelineElementContext<GetBlockStateContext, IBlockState, O, I>, IBlockState>> getBlockStatePipeline,
      final List<Function<TypedPipelineElementContext<GetWorldTypeContext, IDimensionType, O, I>, IDimensionType>> getWorldTypePipeline,
      final List<Function<TypedPipelineElementContext<GetBiomeContext, IBiome, O, I>, IBiome>> getBiomePipeline,
      final List<Function<TypedPipelineElementContext<IsSideSolidContext, Boolean, O, I>, Boolean>> isSideSolidPipeline)
    {
        GetBlockEntityPipeline = getBlockEntityPipeline;
        GetCombinedLightPipeline = getCombinedLightPipeline;
        IsAirBlockPipeline = isAirBlockPipeline;
        GetStrongPowerPipeline = getStrongPowerPipeline;
        GetBlockStatePipeline = getBlockStatePipeline;
        GetWorldTypePipeline = getWorldTypePipeline;
        GetBiomePipeline = getBiomePipeline;
        IsSideSolidPipeline = isSideSolidPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetBlockEntityContext, IBlockEntity, O, I>, IBlockEntity>> getGetBlockEntityPipeline()
    {
        return GetBlockEntityPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetCombinedLightContext, Integer, O, I>, Integer>> getGetCombinedLightPipeline()
    {
        return GetCombinedLightPipeline;
    }

    public List<Function<TypedPipelineElementContext<IsAirBlockContext, Boolean, O, I>, Boolean>> getIsAirBlockPipeline()
    {
        return IsAirBlockPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetStrongPowerContext, Integer, O, I>, Integer>> getGetStrongPowerPipeline()
    {
        return GetStrongPowerPipeline;
    }

    public List<Function<TypedPipelineElementContext<GetBlockStateContext, IBlockState, O, I>, IBlockState>> getGetBlockStatePipeline()
    {
        return GetBlockStatePipeline;
    }

    public List<Function<TypedPipelineElementContext<GetWorldTypeContext, IDimensionType, O, I>, IDimensionType>> getGetWorldTypePipeline()
    {
        return GetWorldTypePipeline;
    }

    public List<Function<TypedPipelineElementContext<GetBiomeContext, IBiome, O, I>, IBiome>> getGetBiomePipeline()
    {
        return GetBiomePipeline;
    }

    public List<Function<TypedPipelineElementContext<IsSideSolidContext, Boolean, O, I>, Boolean>> getIsSideSolidPipeline()
    {
        return IsSideSolidPipeline;
    }
}
