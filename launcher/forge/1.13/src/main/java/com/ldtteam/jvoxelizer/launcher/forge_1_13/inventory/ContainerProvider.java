package com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory;

import com.ldtteam.jvoxelizer.inventory.IContainerProvider;
import com.ldtteam.jvoxelizer.inventory.slot.ISlot;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.slot.Slot;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.item.ItemStack;
import net.minecraft.inventory.Container;

import java.util.List;
import java.util.stream.Collectors;

public class ContainerProvider implements IContainerProvider
{
    private static ContainerProvider ourInstance = new ContainerProvider();

    public static ContainerProvider getInstance()
    {
        return ourInstance;
    }

    private ContainerProvider()
    {
    }

    @Override
    public boolean canAddItemToSlot(final ISlot slotIn, final IItemStack stack, final boolean stackSizeMatters)
    {
        return Container.canAddItemToSlot(Slot.asForge(slotIn), ItemStack.asForge(stack), stackSizeMatters);
    }

    @Override
    public void computeStackSize(final List<ISlot<?>> dragSlotsIn, final int dragModeIn, final IItemStack stack, final int slotStackSize)
    {
        Container.computeStackSize(dragSlotsIn.stream().map(Slot::asForge).collect(Collectors.toSet()), dragModeIn, ItemStack.asForge(stack), slotStackSize);
    }
}
