package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IInventoryCrafting;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent.TextComponent;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;

import static com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.PlayerEntity.asForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack.asForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack.fromForge;
import static com.ldtteam.jvoxelizer.launcher.forge_1_12.util.textcomponent.TextComponent.fromForge;

public class InventoryCrafting implements IInventoryCrafting
{
    private final net.minecraft.inventory.InventoryCrafting forgeInventoryCrafting;

    private InventoryCrafting(final net.minecraft.inventory.InventoryCrafting forgeInventoryCrafting) {this.forgeInventoryCrafting = forgeInventoryCrafting;}

    @Override
    public IItemStack getStackInRowAndColumn(final int row, final int column)
    {
        return ItemStack.fromForge(forgeInventoryCrafting.getStackInRowAndColumn(row, column));
    }

    @Override
    public int getHeight()
    {
        return forgeInventoryCrafting.getHeight();
    }

    @Override
    public int getWidth()
    {
        return forgeInventoryCrafting.getWidth();
    }

    @Override
    public int getSizeInventory()
    {
        return forgeInventoryCrafting.getSizeInventory();
    }

    @Override
    public boolean isEmpty()
    {
        return forgeInventoryCrafting.isEmpty();
    }

    @Override
    public IItemStack getStackInSlot(final int index)
    {
        return ItemStack.fromForge(forgeInventoryCrafting.getStackInSlot(index));
    }

    @Override
    public IItemStack decrStackSize(final int index, final int count)
    {
        return ItemStack.fromForge(forgeInventoryCrafting.decrStackSize(index, count));
    }

    @Override
    public IItemStack removeStackFromSlot(final int index)
    {
        return ItemStack.fromForge(forgeInventoryCrafting.removeStackFromSlot(index));
    }

    @Override
    public void setInventorySlotContents(final int index, final IItemStack stack)
    {
        forgeInventoryCrafting.setInventorySlotContents(index, ItemStack.asForge(stack));
    }

    @Override
    public int getInventoryStackLimit()
    {
        return forgeInventoryCrafting.getInventoryStackLimit();
    }

    @Override
    public void markDirty()
    {
        forgeInventoryCrafting.markDirty();
    }

    @Override
    public boolean isUsableByPlayer(final IPlayerEntity player)
    {
        return forgeInventoryCrafting.isUsableByPlayer(PlayerEntity.asForge(player));
    }

    @Override
    public void openInventory(final IPlayerEntity player)
    {
        forgeInventoryCrafting.openInventory(PlayerEntity.asForge(player));
    }

    @Override
    public void closeInventory(final IPlayerEntity player)
    {
        forgeInventoryCrafting.closeInventory(PlayerEntity.asForge(player));
    }

    @Override
    public boolean isItemValidForSlot(final int index, final IItemStack stack)
    {
        return forgeInventoryCrafting.isItemValidForSlot(index, ItemStack.asForge(stack));
    }

    @Override
    public int getField(final int id)
    {
        return forgeInventoryCrafting.getField(id);
    }

    @Override
    public void setField(final int id, final int value)
    {
        forgeInventoryCrafting.setField(id, value);
    }

    @Override
    public int getFieldCount()
    {
        return forgeInventoryCrafting.getFieldCount();
    }

    @Override
    public void clear()
    {
        forgeInventoryCrafting.clear();
    }

    @Override
    public String getName()
    {
        return forgeInventoryCrafting.getName();
    }

    @Override
    public boolean hasCustomName()
    {
        return forgeInventoryCrafting.hasCustomName();
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return TextComponent.fromForge(forgeInventoryCrafting.getDisplayName());
    }

    private net.minecraft.inventory.InventoryCrafting getForgeInventoryCrafting()
    {
        return forgeInventoryCrafting;
    }

    public static net.minecraft.inventory.InventoryCrafting asForge(IInventoryCrafting inventoryCrafting)
    {
        if (inventoryCrafting instanceof net.minecraft.inventory.InventoryCrafting)
            return (net.minecraft.inventory.InventoryCrafting) inventoryCrafting;

        return ((InventoryCrafting) inventoryCrafting).getForgeInventoryCrafting();
    }

    public static IInventoryCrafting fromForge(net.minecraft.inventory.InventoryCrafting inventoryCrafting)
    {
        if (inventoryCrafting instanceof IInventoryCrafting)
            return (IInventoryCrafting) inventoryCrafting;

        return new InventoryCrafting(inventoryCrafting);
    }
}
