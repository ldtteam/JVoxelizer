package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.handling.IInventory;

final class ISlotBuilderProviderHolder extends AbstractHolder<ISlotBuilderProvider> implements ISlotBuilderProvider
{
    private static ISlotBuilderProviderHolder ourInstance = new ISlotBuilderProviderHolder();

    public static ISlotBuilderProviderHolder getInstance()
    {
        return ourInstance;
    }

    private ISlotBuilderProviderHolder()
    {
        super(ISlotBuilder.class.getName());
    }

    @Override
    public <I> ISlotBuilder<?, I, ISlot<I>> provide(final IInventory inventory, final int index, final int x, final int y, final I instanceData)
    {
        return getProvider().provide(inventory, index, x, y, instanceData);
    }
}