package com.ldtteam.jvoxelizer.item.crafting;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.inventory.IInventoryCrafting;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.registries.IRegistryEntry;

import java.util.List;

public interface IRecipe extends IRegistryEntry<IRecipe>
{
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    boolean matches(IInventoryCrafting inv, IDimension worldIn);

    /**
     * Returns an Item that is the result of this recipe
     */
    IItemStack getCraftingResult(IInventoryCrafting inv);

    /**
     * Used to determine if this recipe can fit in a grid of the given width/height
     */
    boolean canFit(int width, int height);

    IItemStack getRecipeOutput();

    List<IItemStack> getRemainingItems(IInventoryCrafting inv);

    List<IIngredient> getIngredients();

    boolean isDynamic();

    String getGroup();
}