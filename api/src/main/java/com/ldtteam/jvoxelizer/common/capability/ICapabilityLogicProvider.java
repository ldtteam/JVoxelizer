package com.ldtteam.jvoxelizer.common.capability;

import com.ldtteam.jvoxelizer.item.handling.IItemHandler;

public interface ICapabilityLogicProvider
{

    ICapability<IItemHandler> getItemHandlerCapability();
}
