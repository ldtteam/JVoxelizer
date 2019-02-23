package com.ldtteam.jvoxelizer.item;

import com.ldtteam.jvoxelizer.util.nbt.INBTSerializable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface IItemStack extends INBTSerializable
{

    /**
     * Creates a new empty IItemStack.
     * @return an empty IItemStack.
     */
    static IItemStack create()
    {
        return IItemStackProviderHolder.getInstance().provide();
    }

    static boolean areItemStackTagsEqual(IItemStack pItemStack1, IItemStack pItemStack2)
    {
        //TODO: Implement:
        throw new NotImplementedException();
    }

    /**
     * Indicates if this {@link IItemStack} is empty.
     *
     * @return {@code True} when empty, false when not.
     */
    boolean isEmpty();

    /**
     * Creates a clone of this {@link IItemStack}.
     *
     * @return The clone.
     */
    IItemStack copy();

    /**
     * The amount of items in the stack.
     *
     * @return The amount
     */
    int getCount();

    boolean isStackable();

    IItem<?> getItem();

    int getItemDamage();

    boolean hasTagCompound();

    void setCount(int pStackSize);

    int getMaxStackSize();

    void grow(int mergeCount);

    void shrink(int i);

    boolean isItemEqual(IItemStack stack2);

    boolean getHasSubtypes();

    Object getTranslationKey(IItemStack pItemStack);
}
