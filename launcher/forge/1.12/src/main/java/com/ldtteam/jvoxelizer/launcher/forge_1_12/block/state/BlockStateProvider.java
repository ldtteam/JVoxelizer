package com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state;

import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.block.state.IBlockStateProvider;
import net.minecraft.init.Blocks;

public class BlockStateProvider implements IBlockStateProvider
{
    private static BlockStateProvider ourInstance = new BlockStateProvider();

    public static BlockStateProvider getInstance()
    {
        return ourInstance;
    }

    private BlockStateProvider()
    {
    }

    @Override
    public IBlockState provide()
    {
        return new BlockState();
    }

    @Override
    public IBlockState provideDefault()
    {
        return new BlockState(Blocks.AIR.getDefaultState());
    }
}
