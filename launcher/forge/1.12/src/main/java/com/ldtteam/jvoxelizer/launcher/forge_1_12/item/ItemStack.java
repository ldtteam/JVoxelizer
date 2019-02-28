package com.ldtteam.jvoxelizer.launcher.forge_1_12.item;

import com.ldtteam.jvoxelizer.item.IItem;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.nbt.NBTCompound;
import com.ldtteam.jvoxelizer.util.nbt.INBTCompound;
import net.minecraft.nbt.NBTTagCompound;
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
        return new Item(forgeItemStack.getItem());
    }

    @Override
    public int getItemDamage()
    {
        return forgeItemStack.getItemDamage();
    }

    @Override
    public boolean hasTagCompound()
    {
        return forgeItemStack.hasTagCompound();
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
        return forgeItemStack.getHasSubtypes();
    }

    //todo orion
    @Override
    public Object getTranslationKey(final IItemStack pItemStack)
    {
        return ;
    }

    //todo orion
    @Override
    public INBTCompound write()
    {
        return new NBTCompound(forgeItemStack.writeToNBT(new NBTTagCompound()));
    }

    //todo orion
    @Override
    public void read(final INBTCompound data)
    {
        forgeItemStack = new net.minecraft.item.ItemStack(((NBTTagCompound)data).getCompoundTag())
    }

    /**
     * Get the wrapped forge item stack.
     * @return net.minecraft.item.ItemStack.
     */
    public net.minecraft.item.ItemStack getForgeItem()
    {
        return this.forgeItemStack;
    }

}
