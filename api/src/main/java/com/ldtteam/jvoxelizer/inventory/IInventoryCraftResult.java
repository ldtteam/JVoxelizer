package com.ldtteam.jvoxelizer.inventory;

import com.ldtteam.jvoxelizer.item.crafting.IRecipe;

public interface IInventoryCraftResult
{
    void setRecipeUsed(IRecipe p_193056_1_);

    IRecipe getRecipeUsed();
}
