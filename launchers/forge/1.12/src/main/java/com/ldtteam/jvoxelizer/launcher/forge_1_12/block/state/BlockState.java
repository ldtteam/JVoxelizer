package com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state;

import com.ldtteam.jvoxelizer.block.IBlock;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.Block;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt.NBTCompound;
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
    public INBTCompound write()
    {
        return new NBTCompound(NBTUtil.writeBlockState(new NBTTagCompound(), forgeBlockState));
    }

    @Override
    public void read(final INBTCompound data)
    {
        forgeBlockState = NBTUtil.readBlockState(((NBTCompound) data).forgeNbtCompound);
    }
}
