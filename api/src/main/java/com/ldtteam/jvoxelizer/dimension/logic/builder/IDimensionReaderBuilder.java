package com.ldtteam.jvoxelizer.dimension.logic.builder;

import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.core.logic.TypedPipelineElementContext;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.dimension.IDimensionType;
import com.ldtteam.jvoxelizer.dimension.logic.builder.contexts.*;

import java.util.function.Function;

public interface IDimensionReaderBuilder<C extends IDimensionReaderBuilder<C, I, O>, I, O extends IDimensionReader<I>>
{
    static <G> IDimensionReaderBuilder<?, G, ? extends IDimensionReader<G>> create()
    {
        return IDimensionReaderBuilderProviderHolder.getInstance().provide();
    }

    C GetBlockEntity(Function<TypedPipelineElementContext<GetBlockEntityContext, IBlockEntity, O, I>, IBlockEntity>... components);

    C GetCombinedLight(Function<TypedPipelineElementContext<GetCombinedLightContext, Integer, O, I>, Integer>... components);

    C IsAirBlock(Function<TypedPipelineElementContext<IsAirBlockContext, Boolean, O, I>, Boolean>... components);

    C GetStrongPower(Function<TypedPipelineElementContext<GetStrongPowerContext, Integer, O, I>, Integer>... components);

    C GetBlockState(Function<TypedPipelineElementContext<GetBlockStateContext, IBlockState, O, I>, IBlockState>... components);

    C GetWorldType(Function<TypedPipelineElementContext<GetWorldTypeContext, IDimensionType, O, I>, IDimensionType>... components);

    C GetBiome(Function<TypedPipelineElementContext<GetBiomeContext, IBiome, O, I>, IBiome>... components);

    C IsSideSolid(Function<TypedPipelineElementContext<IsSideSolidContext, Boolean, O, I>, Boolean>... components);

    IDimensionReader<I> build(I guiContext);
}
