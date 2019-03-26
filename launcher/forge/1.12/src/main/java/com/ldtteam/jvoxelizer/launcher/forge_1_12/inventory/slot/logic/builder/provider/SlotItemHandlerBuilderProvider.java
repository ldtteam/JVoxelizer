package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.logic.builder.provider;

import com.ldtteam.jvoxelizer.inventory.slot.ISlotItemHandler;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.ISlotItemHandlerBuilder;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.ISlotItemHandlerBuilderProvider;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.logic.builder.JVoxSlotItemHandlerBuilder;

public class SlotItemHandlerBuilderProvider implements ISlotItemHandlerBuilderProvider
{
    private static SlotItemHandlerBuilderProvider ourInstance = new SlotItemHandlerBuilderProvider();

    public static SlotItemHandlerBuilderProvider getInstance()
    {
        return ourInstance;
    }

    private SlotItemHandlerBuilderProvider()
    {
    }

    @Override
    public <I> ISlotItemHandlerBuilder<?, I, ISlotItemHandler<I>> provide(
      final IItemHandler inventory, final int index, final int x, final int y, final I instanceData)
    {
        return new JVoxSlotItemHandlerBuilder<>(inventory, index, x, y);
    }
}
