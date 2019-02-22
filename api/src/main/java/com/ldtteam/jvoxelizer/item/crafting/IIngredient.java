package com.ldtteam.jvoxelizer.item.crafting;

import com.google.common.base.Predicate;
import com.ldtteam.jvoxelizer.item.IItemStack;
import it.unimi.dsi.fastutil.ints.IntList;

public interface IIngredient extends Predicate<IItemStack>
{
    
    IItemStack[] getMatchingStacks();

    boolean apply(IItemStack p_apply_1_);

    IntList getValidItemStacksPacked();

    boolean isSimple();
}
