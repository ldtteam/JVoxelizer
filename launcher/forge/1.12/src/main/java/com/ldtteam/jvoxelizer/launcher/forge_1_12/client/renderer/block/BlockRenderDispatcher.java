package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.block;

import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.client.renderer.block.IBlockRenderDispatcher;
import com.ldtteam.jvoxelizer.client.renderer.bufferbuilder.IBufferBuilder;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.bufferbuilder.BufferBuilder;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.DimensionReader;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import net.minecraft.client.renderer.BlockRendererDispatcher;

public class BlockRenderDispatcher implements IBlockRenderDispatcher
{
    private final BlockRendererDispatcher forgeBlockRenderDispatcher;

    private BlockRenderDispatcher(final BlockRendererDispatcher forgeBlockRenderDispatcher) {this.forgeBlockRenderDispatcher = forgeBlockRenderDispatcher;}

    @Override
    public void renderBlock(
      final IBlockState state, final IBlockCoordinate pos, final IDimensionReader<?> dimensionReader, final IBufferBuilder buf)
    {
        forgeBlockRenderDispatcher.renderBlock(BlockState.asForge(state), BlockCoordinate.asForge(pos), DimensionReader.asForge(dimensionReader), BufferBuilder.asForge(buf));
    }

    public static BlockRendererDispatcher asForge(final IBlockRenderDispatcher dispatcher)
    {
        if (dispatcher instanceof BlockRendererDispatcher)
            return (BlockRendererDispatcher) dispatcher;

        return ((BlockRenderDispatcher) dispatcher).forgeBlockRenderDispatcher;
    }

    public static IBlockRenderDispatcher fromForge(final BlockRendererDispatcher dispatcher)
    {
        if (dispatcher instanceof IBlockRenderDispatcher)
            return (IBlockRenderDispatcher) dispatcher;

        return new BlockRenderDispatcher(dispatcher);
    }
}
