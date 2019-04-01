package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.block;

import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.client.renderer.block.IBlockRenderDispatcher;
import com.ldtteam.jvoxelizer.client.renderer.bufferbuilder.IBufferBuilder;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.bufferbuilder.BufferBuilder;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.DimensionReader;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import net.minecraft.client.renderer.BlockRendererDispatcher;

public class BlockRenderDispatcher implements IBlockRenderDispatcher, IForgeJVoxelizerWrapper
{
    private final BlockRendererDispatcher forgeBlockRenderDispatcher;

    private BlockRenderDispatcher(final BlockRendererDispatcher forgeBlockRenderDispatcher) {this.forgeBlockRenderDispatcher = forgeBlockRenderDispatcher;}

    @Override
    public void renderBlock(
      final IBlockState state, final IBlockCoordinate pos, final IDimensionReader<?> dimensionReader, final IBufferBuilder buf)
    {
        forgeBlockRenderDispatcher.renderBlock(BlockState.asForge(state), BlockCoordinate.asForge(pos), DimensionReader.asForge(dimensionReader), BufferBuilder.asForge(buf));
    }

    private BlockRendererDispatcher getForgeBlockRenderDispatcher()
    {
        return forgeBlockRenderDispatcher;
    }

    public static BlockRendererDispatcher asForge(final IBlockRenderDispatcher dispatcher)
    {
        if (dispatcher instanceof BlockRendererDispatcher)
        {
            return (BlockRendererDispatcher) dispatcher;
        }

        if (dispatcher == null)
        {
            return null;
        }

        if (!(dispatcher instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("BlockRenderDispatcher is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) dispatcher).getForgeInstance();
    }

    public static IBlockRenderDispatcher fromForge(final BlockRendererDispatcher dispatcher)
    {
        if (dispatcher instanceof IBlockRenderDispatcher)
        {
            return (IBlockRenderDispatcher) dispatcher;
        }

        return new BlockRenderDispatcher(dispatcher);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeBlockRenderDispatcher();
    }
}
