package com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state;

import com.ldtteam.jvoxelizer.block.IBlock;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.Block;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.DimensionReader;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.facing.Facing;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt.NBTCompound;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;

public class BlockState implements IBlockState
{

    private net.minecraft.block.state.IBlockState forgeBlockState;

    public BlockState()
    {
    }

    public BlockState(final net.minecraft.block.state.IBlockState forgeBlockState)
    {
        this.forgeBlockState = forgeBlockState;
    }

    @Override
    public IBlock getBlock()
    {
        if (forgeBlockState == null) throw new IllegalStateException("JVoxelizer IBlockState has not been initialized with its counterpart!");

        return new Block(forgeBlockState.getBlock());
    }

    @Override
    public boolean isSideSolid(
      final IDimensionReader<?> dimensionReader, final IBlockCoordinate pos, final IFacing side)
    {
        return forgeBlockState.isSideSolid(((DimensionReader) dimensionReader).getForgeBlockAcces(), ((BlockCoordinate) pos).getForgeBlockPos(), ((Facing) side).getForgeSide());
    }

    @Override
    public INBTCompound write()
    {
        return new NBTCompound(NBTUtil.writeBlockState(new NBTTagCompound(), forgeBlockState));
    }

    @Override
    public void read(final INBTCompound data)
    {
        forgeBlockState = NBTUtil.readBlockState(((NBTCompound) data).forgeNbtCompound);
    }

    public net.minecraft.block.state.IBlockState getForgeBlockState()
    {
        return forgeBlockState;
    }

    public static net.minecraft.block.state.IBlockState asForge(IBlockState blockState)
    {
        if (blockState instanceof net.minecraft.block.state.IBlockState)
            return (net.minecraft.block.state.IBlockState) blockState;

        return ((BlockState) blockState).getForgeBlockState();
    }

    public static IBlockState fromForge(net.minecraft.block.state.IBlockState blockState)
    {
        if (blockState instanceof IBlockState)
            return (IBlockState) blockState;

        return new BlockState(blockState);
    }
}
