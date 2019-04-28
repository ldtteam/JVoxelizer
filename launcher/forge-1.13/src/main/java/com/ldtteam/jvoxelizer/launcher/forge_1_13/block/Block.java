package com.ldtteam.jvoxelizer.launcher.forge_1_13.block;

import com.ldtteam.jvoxelizer.block.IBlock;
import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.block.entity.BlockEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension.Dimension;
import net.minecraft.block.BlockAir;

public class Block implements IBlock, IForgeJVoxelizerWrapper
{
    private net.minecraft.block.Block forgeBlock;

    private Block(final net.minecraft.block.Block forgeBlock)
    {
        this.forgeBlock = forgeBlock;
    }

    @Override
    public boolean isAir()
    {
        return forgeBlock instanceof BlockAir;
    }

    @Override
    public IBlockEntity createBlockEntity(
      final IDimension dimension, final IBlockState state)
    {
        return BlockEntity.fromForge(forgeBlock.createTileEntity(BlockState.asForge(state), Dimension.asForge(dimension)));
    }

    private net.minecraft.block.Block getForgeBlock()
    {
        return forgeBlock;
    }

    public static net.minecraft.block.Block asForge(IBlock block)
    {
        if (block instanceof net.minecraft.block.Block)
        {
            return (net.minecraft.block.Block) block;
        }

        if (!(block instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("Block is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) block).getForgeInstance();
    }

    public static IBlock fromForge(net.minecraft.block.Block block)
    {
        if (block instanceof IBlock)
        {
            return (IBlock) block;
        }

        return new Block(block);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeBlock();
    }
}
