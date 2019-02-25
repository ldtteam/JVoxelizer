package com.ldtteam.jvoxelizer.dimension;

/**
 * Represents a single world, also called dimension, in the game
 */
public interface IDimension<I> extends IDimensionReader<I>
{

    int getId();
}
