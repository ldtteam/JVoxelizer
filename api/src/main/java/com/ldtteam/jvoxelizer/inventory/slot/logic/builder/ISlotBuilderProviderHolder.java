package com.ldtteam.jvoxelizer.inventory.slot.logic.builder;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;

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
    public <C extends ISlotBuilder<C, I, O>, I, O extends ISlot<I>> C provide(final I instanceData)
    {
        return getProvider().provide(instanceData);
    }
}