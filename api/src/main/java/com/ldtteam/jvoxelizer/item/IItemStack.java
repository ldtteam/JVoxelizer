package com.ldtteam.jvoxelizer.item;

import com.ldtteam.jvoxelizer.util.nbt.INBTSerializable;

public interface IItemStack extends INBTSerializable
{

    /**
     * Creates a new empty IItemStack.
     * @return an empty IItemStack.
     */
    static IItemStack create()
    {
        return IItemStackProviderHolder.getInstance().provide();
    }

    /**
     * Indicates if this {@link IItemStack} is empty.
     *
     * @return {@code True} when empty, false when not.
     */
    boolean isEmpty();

    /**
     * Creates a clone of this {@link IItemStack}.
     *
     * @return The clone.
     */
    IItemStack copy();
}
