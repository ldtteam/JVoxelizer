package com.ldtteam.jvoxelizer.common.capability;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;

final class ICapabilityLogicHolder extends AbstractHolder<ICapabilityLogicProvider> implements ICapabilityLogicProvider
{
    private static ICapabilityLogicHolder ourInstance = new ICapabilityLogicHolder();

    public static ICapabilityLogicHolder getInstance()
    {
        return ourInstance;
    }

    private ICapabilityLogicHolder()
    {
        super(ICapability.class.getName());
    }

    @Override
    public ICapability<IItemHandler> getItemHandlerCapability()
    {
        return getProvider().getItemHandlerCapability();
    }
}