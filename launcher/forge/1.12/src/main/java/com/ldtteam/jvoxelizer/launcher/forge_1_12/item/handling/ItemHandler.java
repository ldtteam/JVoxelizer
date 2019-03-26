package com.ldtteam.jvoxelizer.launcher.forge_1_12.item.handling;

import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.handling.IItemHandler;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;

public class ItemHandler implements IItemHandler
{
    private final net.minecraftforge.items.IItemHandler forgeItemHandler;

    private ItemHandler(final net.minecraftforge.items.IItemHandler forgeItemHandler) {this.forgeItemHandler = forgeItemHandler;}

    @Override
    public IItemStack getStackInSlot(final int inventoryIndex)
    {
        return ItemStack.fromForge(forgeItemHandler.getStackInSlot(inventoryIndex));
    }

    private net.minecraftforge.items.IItemHandler getForgeItemHandler()
    {
        return forgeItemHandler;
    }

    public static IItemHandler fromForge(net.minecraftforge.items.IItemHandler itemHandler)
    {
        if (itemHandler instanceof IItemHandler)
            return (IItemHandler) itemHandler;

        return new ItemHandler(itemHandler);
    }

    public static net.minecraftforge.items.IItemHandler asForge(IItemHandler itemHandler)
    {
        if (itemHandler instanceof net.minecraftforge.items.IItemHandler)
            return (net.minecraftforge.items.IItemHandler) itemHandler;

        return ((ItemHandler) itemHandler).getForgeItemHandler();
    }
}
