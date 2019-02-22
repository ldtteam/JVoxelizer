package com.ldtteam.jvoxelizer.entity.ai;

import java.util.UUID;

public interface IAttributeModifier
{
    UUID getID();

    String getName();

    int getOperation();

    double getAmount();

    /**
     * @see #isSaved
     */
    boolean isSaved();

    /**
     * @see #isSaved
     */
    IAttributeModifier setSaved(boolean saved);
}
