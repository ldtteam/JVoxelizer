package com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory;

import com.ldtteam.jvoxelizer.inventory.IInventoryCraftResult;
import com.ldtteam.jvoxelizer.item.crafting.IRecipe;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.item.crafting.Recipe;

public class InventoryCraftResult extends Inventory implements IInventoryCraftResult
{
    private final net.minecraft.inventory.InventoryCraftResult forgeInventoryCraftResult;

    private InventoryCraftResult(final net.minecraft.inventory.InventoryCraftResult forgeInventoryCraftResult)
    {
        super(forgeInventoryCraftResult);
        this.forgeInventoryCraftResult = forgeInventoryCraftResult;
    }

    @Override
    public void setRecipeUsed(final IRecipe p_193056_1_)
    {
        forgeInventoryCraftResult.setRecipeUsed(Recipe.asForge(p_193056_1_));
    }

    @Override
    public IRecipe getRecipeUsed()
    {
        return Recipe.fromForge(forgeInventoryCraftResult.getRecipeUsed());
    }

    private net.minecraft.inventory.InventoryCraftResult getForgeInventoryCraftResult()
    {
        return forgeInventoryCraftResult;
    }

    public static IInventoryCraftResult fromForge(net.minecraft.inventory.InventoryCraftResult inventoryCraftResult)
    {
        if (inventoryCraftResult instanceof IInventoryCraftResult)
        {
            return (IInventoryCraftResult) inventoryCraftResult;
        }

        return new InventoryCraftResult(inventoryCraftResult);
    }

    public static net.minecraft.inventory.InventoryCraftResult asForge(IInventoryCraftResult inventoryCraftResult)
    {
        if (inventoryCraftResult instanceof net.minecraft.inventory.InventoryCraftResult)
        {
            return (net.minecraft.inventory.InventoryCraftResult) inventoryCraftResult;
        }

        if (inventoryCraftResult == null)
        {
            return null;
        }

        if (!(inventoryCraftResult instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("InventoryCraftResult is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) inventoryCraftResult).getForgeInstance();
    }
}
