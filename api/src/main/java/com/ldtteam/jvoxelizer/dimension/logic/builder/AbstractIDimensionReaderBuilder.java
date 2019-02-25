package com.ldtteam.jvoxelizer.dimension.logic.builder;

import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.dimension.*;
import com.ldtteam.jvoxelizer.dimension.logic.builder.contexts.*;
import java.util.function.Function;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.ldtteam.jvoxelizer.core.logic.*;

public abstract class AbstractIDimensionReaderBuilder<C extends IDimensionReaderBuilder<C, I, O>, I, O extends IDimensionReader<I>> implements IDimensionReaderBuilder<C, I, O>
{

    @Override
    public C GetBlockEntity(Function<TypedPipelineElementContext<GetBlockEntityContext, IBlockEntity, O, I>, IBlockEntity>... components) {
        this.GetBlockEntityPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetBlockEntityContext, IBlockEntity, O, I>, IBlockEntity>> GetBlockEntityPipeline = new ArrayList<>();

    @Override
    public C GetCombinedLight(Function<TypedPipelineElementContext<GetCombinedLightContext, Integer, O, I>, Integer>... components) {
        this.GetCombinedLightPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetCombinedLightContext, Integer, O, I>, Integer>> GetCombinedLightPipeline = new ArrayList<>();

    @Override
    public C IsAirBlock(Function<TypedPipelineElementContext<IsAirBlockContext, Boolean, O, I>, Boolean>... components) {
        this.IsAirBlockPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<IsAirBlockContext, Boolean, O, I>, Boolean>> IsAirBlockPipeline = new ArrayList<>();

    @Override
    public C GetStrongPower(Function<TypedPipelineElementContext<GetStrongPowerContext, Integer, O, I>, Integer>... components) {
        this.GetStrongPowerPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetStrongPowerContext, Integer, O, I>, Integer>> GetStrongPowerPipeline = new ArrayList<>();

    @Override
    public C GetBlockState(Function<TypedPipelineElementContext<GetBlockStateContext, IBlockState, O, I>, IBlockState>... components) {
        this.GetBlockStatePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetBlockStateContext, IBlockState, O, I>, IBlockState>> GetBlockStatePipeline = new ArrayList<>();

    @Override
    public C GetWorldType(Function<TypedPipelineElementContext<GetWorldTypeContext, IDimensionType, O, I>, IDimensionType>... components) {
        this.GetWorldTypePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetWorldTypeContext, IDimensionType, O, I>, IDimensionType>> GetWorldTypePipeline = new ArrayList<>();

    @Override
    public C GetBiome(Function<TypedPipelineElementContext<GetBiomeContext, IBiome, O, I>, IBiome>... components) {
        this.GetBiomePipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<GetBiomeContext, IBiome, O, I>, IBiome>> GetBiomePipeline = new ArrayList<>();

    @Override
    public C IsSideSolid(Function<TypedPipelineElementContext<IsSideSolidContext, Boolean, O, I>, Boolean>... components) {
        this.IsSideSolidPipeline.addAll(Arrays.asList(components));
        return (C) this;
    }

    private final List<Function<TypedPipelineElementContext<IsSideSolidContext, Boolean, O, I>, Boolean>> IsSideSolidPipeline = new ArrayList<>();
}
