package com.ldtteam.jvoxelizer.inventory;

import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.item.IItem;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.handling.IInventory;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import com.ldtteam.jvoxelizer.util.nbt.INBTList;
import com.ldtteam.jvoxelizer.util.textcomponent.ITextComponent;
import com.ldtteam.jvoxelizer.dimension.IDimension;

public interface IInventoryPlayer extends IInventory
{
    static int getHotbarSize()
    {
        return 9;
    }

    static boolean isHotbar(int index)
    {
        return index >= 0 && index < 9;
    }

    IItemStack getCurrentItem();

    int getFirstEmptyStack();

    void setPickedItemStack(IItemStack stack);

    void pickItem(int index);

    int getSlotFor(IItemStack stack);

    int findSlotMatchingUnusedItem(IItemStack p_194014_1_);

    int getBestHotbarSlot();

    void changeCurrentItem(int direction);

    int clearMatchingItems(IItem itemIn, int metadataIn, int removeCount, INBTCompound itemNBT);

    int storeItemStack(IItemStack itemStackIn);

    void decrementAnimations();

    boolean addItemStackToInventory(IItemStack itemStackIn);

    boolean add(int p_191971_1_, IItemStack p_191971_2_);

    void placeItemBackInInventory(IDimension p_191975_1_, IItemStack p_191975_2_);

    void deleteStack(IItemStack stack);

    float getDestroySpeed(IBlockState state);

    INBTList writeToNBT(INBTList nbtTagListIn);

    void readFromNBT(INBTList nbtTagListIn);

    boolean canHarvestBlock(IBlockState state);

    IItemStack armorItemInSlot(int slotIn);

    void damageArmor(float damage);

    void dropAllItems();

    int getTimesChanged();

    void setItemStack(IItemStack itemStackIn);

    IItemStack getItemStack();

    boolean hasItemStack(IItemStack itemStackIn);

    void copyInventory(IInventoryPlayer playerInventory);
}
