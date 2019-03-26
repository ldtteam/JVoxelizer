package com.ldtteam.jvoxelizer.inventory;

import com.ldtteam.jvoxelizer.item.crafting.IRecipe;
import com.ldtteam.jvoxelizer.item.handling.IInventory;

public interface IInventoryCraftResult extends IInventory
{
    void setRecipeUsed(IRecipe p_193056_1_);

    IRecipe getRecipeUsed();
}
