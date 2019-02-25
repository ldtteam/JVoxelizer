package com.ldtteam.jvoxelizer.common.capability;

import com.ldtteam.jvoxelizer.item.handling.IItemHandler;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface ICapability<T>
{

    static ICapability<IItemHandler> getItemHandlerCapability()
    {
        throw new NotImplementedException();
    }
}
