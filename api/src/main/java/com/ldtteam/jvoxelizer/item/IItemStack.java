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
}
