package com.ldtteam.jvoxelizer.block;

import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.dimension.IDimension;

public interface IBlock
{
    boolean isAir();

    IBlockEntity createBlockEntity(IDimension dimension, IBlockState state);
}
