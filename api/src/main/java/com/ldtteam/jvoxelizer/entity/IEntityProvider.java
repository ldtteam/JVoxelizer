package com.ldtteam.jvoxelizer.entity;

import com.ldtteam.jvoxelizer.dimension.IDimension;

import java.util.UUID;

/**
 * Provides the logic for creating new entities in different situations.
 */
public interface IEntityProvider
{
    IEntity provide(IDimension<?> dimension);

    IEntity provide(UUID id);

    IEntity provide();
}
