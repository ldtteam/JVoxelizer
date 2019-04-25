package com.ldtteam.jvoxelizer.launcher.forge_1_13.item;

import com.ldtteam.jvoxelizer.item.IItem;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.nbt.NBTCompound;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;

public class ItemStack implements IItemStack
{
    private net.minecraft.item.ItemStack forgeItemStack;

    private ItemStack(@NotNull final net.minecraft.item.ItemStack forgeItemStack)
    {
        this.forgeItemStack = forgeItemStack;
    }

    @Override
    public boolean isEmpty()
    {
        return forgeItemStack.isEmpty();
    }

    @Override
    public IItemStack copy()
    {
        return new ItemStack(forgeItemStack.copy());
    }

    @Override
    public int getCount()
    {
        return forgeItemStack.getCount();
    }

    @Override
    public boolean isStackable()
    {
        return forgeItemStack.isStackable();
    }

    @Override
    public IItem<?> getItem()
    {
        return Item.fromForge(forgeItemStack.getItem());
    }

    @Override
    public int getItemDamage()
    {
        return forgeItemStack.getDamage();
    }

    @Override
    public boolean hasTagCompound()
    {
        return forgeItemStack.hasTag();
    }

    @Override
    public void setCount(final int pStackSize)
    {
        forgeItemStack.setCount(pStackSize);
    }

    @Override
    public int getMaxStackSize()
    {
        return forgeItemStack.getMaxStackSize();
    }

    @Override
    public void grow(final int mergeCount)
    {
        forgeItemStack.grow(mergeCount);
    }

    @Override
    public void shrink(final int i)
    {
        forgeItemStack.shrink(i);
    }

    @Override
    public boolean isItemEqual(final IItemStack stack2)
    {
        return forgeItemStack.isItemEqual(((ItemStack) stack2).forgeItemStack);
    }

    @Override
    public boolean getHasSubtypes()
    {
        return false;
    }

    @Override
    public String getTranslationKey()
    {
        return forgeItemStack.getTranslationKey();
    }

    @Override
    public INBTCompound write()
    {
        return NBTCompound.fromForge(forgeItemStack.serializeNBT());
    }

    @Override
    public void read(final INBTCompound data)
    {
        forgeItemStack = net.minecraft.item.ItemStack.read(NBTCompound.asForge(data));
    }

    private net.minecraft.item.ItemStack getForgeItem()
    {
        return this.forgeItemStack;
    }

    public static net.minecraft.item.ItemStack asForge(IItemStack stack)
    {
        return ((ItemStack) stack).getForgeItem();
    }

    public static IItemStack fromForge(net.minecraft.item.ItemStack itemStack)
    {
        return new ItemStack(itemStack);
    }
}
