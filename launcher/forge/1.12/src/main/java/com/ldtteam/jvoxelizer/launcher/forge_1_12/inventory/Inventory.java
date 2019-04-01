package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.handling.IInventory;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent.TextComponent;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;

public class Inventory implements IInventory, IForgeJVoxelizerWrapper
{

    private final net.minecraft.inventory.IInventory forgeInventory;

    public Inventory(final net.minecraft.inventory.IInventory forgeInventory) {this.forgeInventory = forgeInventory;}

    @Override
    public int getSizeInventory()
    {
        return forgeInventory.getSizeInventory();
    }

    @Override
    public boolean isEmpty()
    {
        return forgeInventory.isEmpty();
    }

    @Override
    public IItemStack getStackInSlot(final int index)
    {
        return ItemStack.fromForge(forgeInventory.getStackInSlot(index));
    }

    @Override
    public IItemStack decrStackSize(final int index, final int count)
    {
        return ItemStack.fromForge(forgeInventory.decrStackSize(index, count));
    }

    @Override
    public IItemStack removeStackFromSlot(final int index)
    {
        return ItemStack.fromForge(forgeInventory.removeStackFromSlot(index));
    }

    @Override
    public void setInventorySlotContents(final int index, final IItemStack stack)
    {
        forgeInventory.setInventorySlotContents(index, ItemStack.asForge(stack));
    }

    @Override
    public int getInventoryStackLimit()
    {
        return forgeInventory.getInventoryStackLimit();
    }

    @Override
    public void markDirty()
    {
        forgeInventory.markDirty();
    }

    @Override
    public boolean isUsableByPlayer(final IPlayerEntity player)
    {
        return forgeInventory.isUsableByPlayer(PlayerEntity.asForge(player));
    }

    @Override
    public void openInventory(final IPlayerEntity player)
    {
        forgeInventory.openInventory(PlayerEntity.asForge(player));
    }

    @Override
    public void closeInventory(final IPlayerEntity player)
    {
        forgeInventory.closeInventory(PlayerEntity.asForge(player));
    }

    @Override
    public boolean isItemValidForSlot(final int index, final IItemStack stack)
    {
        return forgeInventory.isItemValidForSlot(index, ItemStack.asForge(stack));
    }

    @Override
    public int getField(final int id)
    {
        return forgeInventory.getField(id);
    }

    @Override
    public void setField(final int id, final int value)
    {
        forgeInventory.setField(id, value);
    }

    @Override
    public int getFieldCount()
    {
        return forgeInventory.getFieldCount();
    }

    @Override
    public void clear()
    {
        forgeInventory.clear();
    }

    @Override
    public String getName()
    {
        return forgeInventory.getName();
    }

    @Override
    public boolean hasCustomName()
    {
        return forgeInventory.hasCustomName();
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return TextComponent.fromForge(forgeInventory.getDisplayName());
    }

    public net.minecraft.inventory.IInventory getForgeInventory()
    {
        return forgeInventory;
    }

    public static net.minecraft.inventory.IInventory asForge(IInventory inventory)
    {
        if (inventory instanceof net.minecraft.inventory.IInventory)
            return (net.minecraft.inventory.IInventory) inventory;

        if (!(inventory instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("Inventory is not a wrapper");

        return ((IForgeJVoxelizerWrapper) inventory).getForgeInstance();
    }

    public static IInventory fromForge(net.minecraft.inventory.IInventory inventory)
    {
        if (inventory instanceof IInventory)
            return (IInventory) inventory;

        return new Inventory(inventory);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeInventory();
    }
}
