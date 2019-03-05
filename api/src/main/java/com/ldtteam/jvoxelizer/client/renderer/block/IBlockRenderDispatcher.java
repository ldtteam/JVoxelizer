package com.ldtteam.jvoxelizer.client.renderer.block;

import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.client.renderer.bufferbuilder.IBufferBuilder;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

/**
 * Handles the rendering of a block into a buffer.
 */
public interface IBlockRenderDispatcher
{
    /**
     * Renders a blocks given state into the buffer.
     *
     * @param state The state to render.
     * @param pos The position of the block
     * @param dimensionReader The dimension that the block is in.
     * @param buf The buffer to render into.
     */
    void renderBlock(IBlockState state, IBlockCoordinate pos, IDimensionReader<?> dimensionReader, IBufferBuilder buf);
}
