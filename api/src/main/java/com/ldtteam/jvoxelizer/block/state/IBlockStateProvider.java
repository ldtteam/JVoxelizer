package com.ldtteam.jvoxelizer.block.state;

public interface IBlockStateProvider
{

    IBlockState provide();

    IBlockState provideDefault();
}
