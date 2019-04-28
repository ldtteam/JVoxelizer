package com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory;

import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.inventory.IInventoryPlayer;
import com.ldtteam.jvoxelizer.item.IItem;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.Dimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.Item;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt.NBTCompound;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt.NBTList;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import com.ldtteam.jvoxelizer.util.nbt.INBTList;
import net.minecraft.nbt.NBTTagList;

public class InventoryPlayer extends Inventory implements IInventoryPlayer
{
    private final net.minecraft.entity.player.InventoryPlayer forgeInventoryPlayer;

    public InventoryPlayer(final net.minecraft.entity.player.InventoryPlayer forgeInventory)
    {
        super(forgeInventory);
        forgeInventoryPlayer = forgeInventory;
    }

    @Override
    public IItemStack getCurrentItemStack()
    {
        return ItemStack.fromForge(forgeInventoryPlayer.getCurrentItem());
    }

    @Override
    public int getFirstEmptyStack()
    {
        return forgeInventoryPlayer.getFirstEmptyStack();
    }

    @Override
    public void setPickedItemStack(final IItemStack stack)
    {
        forgeInventoryPlayer.setPickedItemStack(ItemStack.asForge(stack));
    }

    @Override
    public void pickItem(final int index)
    {
        forgeInventoryPlayer.pickItem(index);
    }

    @Override
    public int getSlotFor(final IItemStack stack)
    {
        return forgeInventoryPlayer.getSlotFor(ItemStack.asForge(stack));
    }

    @Override
    public int findSlotMatchingUnusedItem(final IItemStack p_194014_1_)
    {
        return forgeInventoryPlayer.findSlotMatchingUnusedItem(ItemStack.asForge(p_194014_1_));
    }

    @Override
    public int getBestHotbarSlot()
    {
        return forgeInventoryPlayer.getBestHotbarSlot();
    }

    @Override
    public void changeCurrentItem(final int direction)
    {
        forgeInventoryPlayer.changeCurrentItem(direction);
    }

    @Override
    public int clearMatchingItems(final IItem itemIn, final int metadataIn, final int removeCount, final INBTCompound itemNBT)
    {
        return forgeInventoryPlayer.clearMatchingItems(Item.asForge(itemIn), metadataIn, removeCount, NBTCompound.asForge(itemNBT));
    }

    @Override
    public int storeItemStack(final IItemStack itemStackIn)
    {
        return forgeInventoryPlayer.storeItemStack(ItemStack.asForge(itemStackIn));
    }

    @Override
    public void decrementAnimations()
    {
        forgeInventoryPlayer.decrementAnimations();
    }

    @Override
    public boolean addItemStackToInventory(final IItemStack itemStackIn)
    {
        return forgeInventoryPlayer.addItemStackToInventory(ItemStack.asForge(itemStackIn));
    }

    @Override
    public boolean add(final int p_191971_1_, final IItemStack p_191971_2_)
    {
        return forgeInventoryPlayer.add(p_191971_1_, ItemStack.asForge(p_191971_2_));
    }

    @Override
    public void placeItemBackInInventory(final IDimension p_191975_1_, final IItemStack p_191975_2_)
    {
        forgeInventoryPlayer.placeItemBackInInventory(Dimension.asForge(p_191975_1_), ItemStack.asForge(p_191975_2_));
    }

    @Override
    public void deleteStack(final IItemStack stack)
    {
        forgeInventoryPlayer.deleteStack(ItemStack.asForge(stack));
    }

    @Override
    public float getDestroySpeed(final IBlockState state)
    {
        return forgeInventoryPlayer.getDestroySpeed(BlockState.asForge(state));
    }

    @Override
    public INBTList writeToNBT(final INBTList nbtTagListIn)
    {
        return NBTList.fromForge(forgeInventoryPlayer.writeToNBT(new NBTTagList()));
    }

    @Override
    public void readFromNBT(final INBTList nbtTagListIn)
    {
        forgeInventoryPlayer.readFromNBT(NBTList.asForge(nbtTagListIn));
    }

    @Override
    public boolean canHarvestBlock(final IBlockState state)
    {
        return forgeInventoryPlayer.canHarvestBlock(BlockState.asForge(state));
    }

    @Override
    public IItemStack armorItemInSlot(final int slotIn)
    {
        return ItemStack.fromForge(forgeInventoryPlayer.armorItemInSlot(slotIn));
    }

    @Override
    public void damageArmor(final float damage)
    {
        forgeInventoryPlayer.damageArmor(damage);
    }

    @Override
    public void dropAllItems()
    {
        forgeInventoryPlayer.dropAllItems();
    }

    @Override
    public int getTimesChanged()
    {
        return forgeInventoryPlayer.getTimesChanged();
    }

    @Override
    public void setItemStack(final IItemStack itemStackIn)
    {
        forgeInventoryPlayer.setItemStack(ItemStack.asForge(itemStackIn));
    }

    @Override
    public IItemStack getItemStack()
    {
        return ItemStack.fromForge(forgeInventoryPlayer.getItemStack());
    }

    @Override
    public boolean hasItemStack(final IItemStack itemStackIn)
    {
        return forgeInventoryPlayer.hasItemStack(ItemStack.asForge(itemStackIn));
    }

    @Override
    public void copyInventory(final IInventoryPlayer playerInventory)
    {
        forgeInventoryPlayer.copyInventory(InventoryPlayer.asForge(playerInventory));
    }

    public net.minecraft.entity.player.InventoryPlayer getForgeInventoryPlayer()
    {
        return forgeInventoryPlayer;
    }

    public static IInventoryPlayer fromForge(net.minecraft.entity.player.InventoryPlayer inventoryPlayer)
    {
        if (inventoryPlayer instanceof IInventoryPlayer)
        {
            return (IInventoryPlayer) inventoryPlayer;
        }

        return new InventoryPlayer(inventoryPlayer);
    }

    public static net.minecraft.entity.player.InventoryPlayer asForge(IInventoryPlayer inventoryPlayer)
    {
        if (inventoryPlayer instanceof net.minecraft.entity.player.InventoryPlayer)
        {
            return (net.minecraft.entity.player.InventoryPlayer) inventoryPlayer;
        }

        if (inventoryPlayer == null)
        {
            return null;
        }

        if (!(inventoryPlayer instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("InventoryPlayer is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) inventoryPlayer).getForgeInstance();
    }
}
