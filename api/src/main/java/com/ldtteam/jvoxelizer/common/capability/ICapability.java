package com.ldtteam.jvoxelizer.common.capability;

import com.ldtteam.jvoxelizer.item.handling.IItemHandler;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Represents a single capability an object might have.
 * @param <T> The type of the capability.
 */
public interface ICapability<T>
{

    /**
     * Gives access to the IItemHandler capability.
     *
     * @return The IItemHandler capability.
     */
    static ICapability<IItemHandler> getItemHandlerCapability()
    {
        return ICapabilityLogicHolder.getInstance().getItemHandlerCapability();
    }
}
