package com.ldtteam.jvoxelizer.item.handling;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.nameable.INameable;

public interface IInventory extends INameable
{
    int getSizeInventory();

    boolean isEmpty();

    IItemStack getStackInSlot(int index);

    IItemStack decrStackSize(int index, int count);

    IItemStack removeStackFromSlot(int index);

    void setInventorySlotContents(int index, IItemStack stack);

    int getInventoryStackLimit();

    void markDirty();

    boolean isUsableByPlayer(IPlayerEntity player);

    void openInventory(IPlayerEntity player);

    void closeInventory(IPlayerEntity player);

    boolean isItemValidForSlot(int index, IItemStack stack);

    int getField(int id);

    void setField(int id, int value);

    int getFieldCount();

    void clear();
}
