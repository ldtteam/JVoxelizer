package com.ldtteam.jvoxelizer.launcher.forge_1_12.item;

import com.ldtteam.jvoxelizer.item.IItem;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import org.jetbrains.annotations.NotNull;

public class ItemStack implements IItemStack
{
    private net.minecraft.item.ItemStack forgeItemStack;

    public ItemStack(@NotNull final net.minecraft.item.ItemStack forgeItemStack)
    {
        this.forgeItemStack = forgeItemStack;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public IItemStack copy()
    {
        return null;
    }

    @Override
    public int getCount()
    {
        return 0;
    }

    @Override
    public boolean isStackable()
    {
        return false;
    }

    @Override
    public IItem<?> getItem()
    {
        return null;
    }

    @Override
    public int getItemDamage()
    {
        return 0;
    }

    @Override
    public boolean hasTagCompound()
    {
        return false;
    }

    @Override
    public void setCount(final int pStackSize)
    {

    }

    @Override
    public int getMaxStackSize()
    {
        return 0;
    }

    @Override
    public void grow(final int mergeCount)
    {

    }

    @Override
    public void shrink(final int i)
    {

    }

    @Override
    public boolean isItemEqual(final IItemStack stack2)
    {
        return false;
    }

    @Override
    public boolean getHasSubtypes()
    {
        return false;
    }

    @Override
    public Object getTranslationKey(final IItemStack pItemStack)
    {
        return null;
    }

    @Override
    public INBTCompound write()
    {
        return null;
    }

    @Override
    public void read(final INBTCompound data)
    {

    }

    public net.minecraft.item.ItemStack getForgeItem()
    {
        return null;
    }

}
