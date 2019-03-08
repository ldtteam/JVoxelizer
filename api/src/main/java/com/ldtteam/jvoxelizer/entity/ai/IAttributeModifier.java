package com.ldtteam.jvoxelizer.entity.ai;

import java.util.UUID;

/**
 * Represents a modifier that controls attribute values of entities.
 */
public interface IAttributeModifier
{
    /**
     * The id of the modifier.
     *
     * @return The id.
     */
    UUID getID();

    /**
     * The name of the modifier.
     *
     * @return The name.
     */
    String getName();

    /**
     * The type of operation that the modifier applies to the attributes value.
     *
     * @return The type of the operation.
     */
    int getOperation();

    /**
     * The amount or factor that is used to modify the attributes value.
     *
     * @return The amount or factor that is used to modify the attributes value.
     */
    double getAmount();

    /** Indicates if this attribute modifier should be saved to disk
     *
     * @return True to save to disk, false to not save.
     */
    boolean isSaved();

    /**
     * @see #isSaved
     */
    IAttributeModifier setSaved(boolean saved);
}
