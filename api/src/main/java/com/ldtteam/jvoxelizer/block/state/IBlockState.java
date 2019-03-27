package com.ldtteam.jvoxelizer.block.state;

import com.ldtteam.jvoxelizer.block.IBlock;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
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

    /**
     * Indicates if the given side is solid in the given dimension if a block is located on the given position.
     *
     * @param dimensionReader The dimension to check in.
     * @param pos The position to check in.
     * @param side The side to check for.
     *
     * @return True when solid, false when not.
     */
    boolean isSideSolid(IDimensionReader<?> dimensionReader, IBlockCoordinate pos, IFacing side);
}
