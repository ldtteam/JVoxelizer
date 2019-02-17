package com.ldtteam.jvoxelizer.block.state;

import com.ldtteam.jvoxelizer.block.IBlock;
import com.ldtteam.jvoxelizer.util.nbt.INBTSerializable;

/**
 * Represents the state of a Block in the game.
 */
public interface IBlockState extends INBTSerializable
{

    /**
     * Creates a new instance of the {@link IBlockState}
     * @return a new {@link IBlockState}
     */
    static IBlockState create()
    {
        return IBlockStateProviderHolder.getInstance().provide();
    }

    /**
     * The default {@link IBlockState} used by the game.
     * Normally this is the default state of an air block.
     *
     * @return The default {@link IBlockState}.
     */
    static IBlockState defaultState() {
        return IBlockStateProviderHolder.getInstance().provideDefault();
    }

    /**
     * The block of which we are describing a state.
     *
     * @return The underlying block.
     */
    IBlock getBlock();
}
