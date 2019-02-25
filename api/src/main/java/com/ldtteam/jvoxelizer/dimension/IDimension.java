package com.ldtteam.jvoxelizer.dimension;

import com.ldtteam.jvoxelizer.entity.IEntity;

import java.util.List;

/**
 * Represents a single world, also called dimension, in the game
 */
public interface IDimension<I> extends IDimensionReader<I>
{

    int getId();

    List<IEntity> getLoadedEntities();
}
