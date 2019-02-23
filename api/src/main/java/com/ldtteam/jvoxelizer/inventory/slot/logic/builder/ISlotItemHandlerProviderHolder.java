package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.inventory.slot.ISlotItemHandler;

final class ISlotItemHandlerProviderHolder extends AbstractHolder<ISlotItemHandlerProvider> implements ISlotItemHandlerProvider
{
    private static ISlotItemHandlerProviderHolder ourInstance = new ISlotItemHandlerProviderHolder();

    public static ISlotItemHandlerProviderHolder getInstance()
    {
        return ourInstance;
    }

    private ISlotItemHandlerProviderHolder()
    {
        super(ISlotItemHandler.class.getName());
    }

    @Override
    public <C extends ISlotItemHandlerBuilder<C, I, O>, I, O extends ISlotItemHandler<I>> C provide()
    {
        return getProvider().provide();
    }
}