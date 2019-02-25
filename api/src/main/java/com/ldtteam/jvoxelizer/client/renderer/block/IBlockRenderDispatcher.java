package com.ldtteam.jvoxelizer.client.renderer.block;

import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.client.renderer.bufferbuilder.IBufferBuilder;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

public interface IBlockRenderDispatcher
{
    void renderBlock(IBlockState state, IBlockCoordinate pos, IDimensionReader<?> dimensionReader, IBufferBuilder buf);
}
