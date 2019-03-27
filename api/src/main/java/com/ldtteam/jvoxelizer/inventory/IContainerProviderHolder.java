package com.ldtteam.jvoxelizer.inventory;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;

import java.util.List;

final class IContainerProviderHolder extends AbstractHolder<IContainerProvider> implements IContainerProvider
{
    private static IContainerProviderHolder ourInstance = new IContainerProviderHolder();

    public static IContainerProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IContainerProviderHolder()
    {
        super(IContainer.class.getName());
    }

    @Override
    public boolean canAddItemToSlot(final ISlot slotIn, final IItemStack stack, final boolean stackSizeMatters)
    {
        return getProvider().canAddItemToSlot(slotIn, stack, stackSizeMatters);
    }

    @Override
    public void computeStackSize(final List<ISlot<?>> dragSlotsIn, final int dragModeIn, final IItemStack stack, final int slotStackSize)
    {
        getProvider().computeStackSize(dragSlotsIn, dragModeIn, stack, slotStackSize);
    }
}