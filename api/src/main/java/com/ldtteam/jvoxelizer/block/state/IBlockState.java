package com.ldtteam.jvoxelizer.block.state;

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
        return BlockStateProviderHolder.getInstance().provide();
    }
}
