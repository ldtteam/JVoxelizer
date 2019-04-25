package com.ldtteam.jvoxelizer.launcher.forge_1_13.block.state;

import com.ldtteam.jvoxelizer.block.IBlock;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.block.Block;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension.DimensionReader;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.facing.Facing;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.nbt.NBTCompound;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;

public class BlockState implements IBlockState, IForgeJVoxelizerWrapper
{

    private net.minecraft.block.state.IBlockState forgeBlockState;

    private BlockState()
    {
    }

    private BlockState(final net.minecraft.block.state.IBlockState forgeBlockState)
    {
        this.forgeBlockState = forgeBlockState;
    }

    @Override
    public IBlock getBlock()
    {
        if (forgeBlockState == null)
        {
            throw new IllegalStateException("JVoxelizer IBlockState has not been initialized with its counterpart!");
        }

        return Block.fromForge(forgeBlockState.getBlock());
    }

    @Override
    public boolean isSideSolid(
      final IDimensionReader<?> dimensionReader, final IBlockCoordinate pos, final IFacing side)
    {
        return forgeBlockState.getBlockFaceShape(DimensionReader.asForge(dimensionReader), BlockCoordinate.asForge(pos), Facing.asForge(side)) == BlockFaceShape.SOLID;
    }

    @Override
    public INBTCompound write()
    {
        return NBTCompound.fromForge(NBTUtil.writeBlockState(forgeBlockState));
    }

    @Override
    public void read(final INBTCompound data)
    {
        forgeBlockState = NBTUtil.readBlockState(NBTCompound.asForge(data));
    }

    private net.minecraft.block.state.IBlockState getForgeBlockState()
    {
        return forgeBlockState;
    }

    public static net.minecraft.block.state.IBlockState asForge(IBlockState blockState)
    {
        if (blockState instanceof net.minecraft.block.state.IBlockState)
        {
            return (net.minecraft.block.state.IBlockState) blockState;
        }

        if (blockState == null)
        {
            return null;
        }

        if (!(blockState instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("BlockState is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) blockState).getForgeInstance();
    }

    public static IBlockState fromForge(net.minecraft.block.state.IBlockState blockState)
    {
        if (blockState instanceof IBlockState)
        {
            return (IBlockState) blockState;
        }

        return new BlockState(blockState);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeBlockState();
    }
}
