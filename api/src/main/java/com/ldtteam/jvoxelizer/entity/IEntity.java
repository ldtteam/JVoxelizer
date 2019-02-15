package com.ldtteam.jvoxelizer.entity;

import com.ldtteam.jvoxelizer.util.nbt.INBTSerializable;
import com.ldtteam.jvoxelizer.world.IDimension;

import java.util.UUID;

/**
 * Represents an entity in the game.
 */
public interface IEntity extends INBTSerializable
{
    /**
     * Constructor used to create a new entity from its ID.
     * If an entity with the given id already exists, then it is returned instead.
     *
     * @param id The id of the entity to create or find.
     * @return The entity with the given id.
     */
    static IEntity create(UUID id)
    {
        return IEntityProviderHolder.getInstance().provide(id);
    }

    /**
     * Constructor for a blank entity.
     * @return A blank entity.
     */
    static IEntity create()
    {
        return IEntityProviderHolder.getInstance().provide();
    }

    UUID getId();

    IDimension getDimension();
}
