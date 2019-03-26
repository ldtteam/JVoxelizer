package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.inventory.slot.ISlotItemHandler;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;

final class ISlotItemHandlerBuilderProviderHolder extends AbstractHolder<ISlotItemHandlerBuilderProvider> implements ISlotItemHandlerBuilderProvider
{
    private static ISlotItemHandlerBuilderProviderHolder ourInstance = new ISlotItemHandlerBuilderProviderHolder();

    public static ISlotItemHandlerBuilderProviderHolder getInstance()
    {
        return ourInstance;
    }

    private ISlotItemHandlerBuilderProviderHolder()
    {
        super(ISlotItemHandler.class.getName());
    }

    @Override
    public <I> ISlotItemHandlerBuilder<?, I, ISlotItemHandler<I>> provide(
      final IItemHandler inventory, final int index, final int x, final int y, final I instanceData)
    {
        return getProvider().provide(inventory, index, x, y, instanceData);
    }
}