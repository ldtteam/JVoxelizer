package com.ldtteam.jvoxelizer.launcher.forge_1_13.item.handling;

import com.ldtteam.jvoxelizer.item.handling.IItemHandler;
import com.ldtteam.jvoxelizer.item.handling.IItemHandlerProvider;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.EmptyHandler;
import net.minecraftforge.items.wrapper.RangedWrapper;

public class ItemHandlerProvider implements IItemHandlerProvider
{
    private static ItemHandlerProvider ourInstance = new ItemHandlerProvider();

    public static ItemHandlerProvider getInstance()
    {
        return ourInstance;
    }

    private ItemHandlerProvider()
    {
    }

    @Override
    public IItemHandler provideEmpty()
    {
        return ItemHandler.fromForge(new EmptyHandler());
    }

    @Override
    public IItemHandler provideRanged(final IItemHandler other, final int minSlot, final int maxSlotExlcuding)
    {
        final net.minecraftforge.items.IItemHandler forgeHandler = ItemHandler.asForge(other);
        if (!(forgeHandler instanceof IItemHandlerModifiable))
        {
            throw new IllegalArgumentException("Only modifiable itemhandlers can be range wrapped.");
        }

        final IItemHandlerModifiable forgeModifiableItemHandler = (IItemHandlerModifiable) forgeHandler;
        return ItemHandler.fromForge(new RangedWrapper(forgeModifiableItemHandler, minSlot, maxSlotExlcuding));
    }
}
