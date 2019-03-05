package com.ldtteam.jvoxelizer.block.state;

/**
 * Provider that gives access to constructors and static fields for blockstates.
 */
public interface IBlockStateProvider
{
    /**
     * Creates a new empty dummy IBlockState.
     * Usefull for when blockstates are loaded from disk
     *
     * @return The dummy empty blockstate.
     */
    IBlockState provide();

    /**
     * Gives access to the default blockstate for the game.
     * In most cases this is the default blockstate of the block that represents air.
     *
     * @return The default blockstate for the game.
     */
    IBlockState provideDefault();
}
