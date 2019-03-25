package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.logic.builder.provider;

import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.ISlotBuilder;
import com.ldtteam.jvoxelizer.inventory.slot.logic.builder.ISlotBuilderProvider;
import com.ldtteam.jvoxelizer.item.handling.IInventory;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.slot.logic.builder.JVoxSlotBuilder;

public class SlotBuilderProvider implements ISlotBuilderProvider
{
    private static SlotBuilderProvider ourInstance = new SlotBuilderProvider();

    public static SlotBuilderProvider getInstance()
    {
        return ourInstance;
    }

    private SlotBuilderProvider()
    {
    }

    @Override
    public <I> ISlotBuilder<?, I, ISlot<I>> provide(final IInventory inventory, final int index, final int x, final int y, final I instanceData)
    {
        return new JVoxSlotBuilder<I>(inventory, index, x, y);
    }
}
