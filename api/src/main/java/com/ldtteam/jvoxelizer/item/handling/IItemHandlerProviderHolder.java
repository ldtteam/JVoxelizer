package com.ldtteam.jvoxelizer.item.handling;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IItemHandlerProviderHolder extends AbstractHolder<IItemHandlerProvider> implements IItemHandlerProvider
{
    private static IItemHandlerProviderHolder ourInstance = new IItemHandlerProviderHolder();

    public static IItemHandlerProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IItemHandlerProviderHolder()
    {
        super(IItemHandler.class.getName());
    }

    @Override
    public IItemHandler provideEmpty()
    {
        return getProvider().provideEmpty();
    }

    @Override
    public IItemHandler provideRanged(final IItemHandler other, final int minSlot, final int maxSlotExlcuding)
    {
        return getProvider().provideRanged(other, minSlot, maxSlotExlcuding);
    }
}