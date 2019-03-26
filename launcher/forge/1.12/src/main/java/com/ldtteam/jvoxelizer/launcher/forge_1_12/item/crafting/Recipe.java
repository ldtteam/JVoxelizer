package com.ldtteam.jvoxelizer.launcher.forge_1_12.item.crafting;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.inventory.IInventoryCrafting;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.crafting.IIngredient;
import com.ldtteam.jvoxelizer.item.crafting.IRecipe;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.Dimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.InventoryCrafting;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.identifier.Identifier;
import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

import java.util.List;
import java.util.stream.Collectors;

public class Recipe implements IRecipe
{

    private net.minecraft.item.crafting.IRecipe forgeRecipe;

    private Recipe(final net.minecraft.item.crafting.IRecipe forgeRecipe) {this.forgeRecipe = forgeRecipe;}

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
    public boolean matches(final IInventoryCrafting inv, final IDimension worldIn)
    {
        return forgeRecipe.matches(InventoryCrafting.asForge(inv), Dimension.asForge(worldIn));
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    @Override
    public IItemStack getCraftingResult(final IInventoryCrafting inv)
    {
        return ItemStack.fromForge(forgeRecipe.getCraftingResult(InventoryCrafting.asForge(inv)));
    }

    /**
     * Used to determine if this recipe can fit in a grid of the given width/height
     */
    @Override
    public boolean canFit(final int width, final int height)
    {
        return forgeRecipe.canFit(width, height);
    }

    @Override
    public IItemStack getRecipeOutput()
    {
        return ItemStack.fromForge(forgeRecipe.getRecipeOutput());
    }

    @Override
    public List<IItemStack> getRemainingItems(final IInventoryCrafting inv)
    {
        return forgeRecipe.getRemainingItems(InventoryCrafting.asForge(inv)).stream().map(i -> ItemStack.fromForge(i)).collect(Collectors.toList());
    }

    @Override
    public List<IIngredient> getIngredients()
    {
        return forgeRecipe.getIngredients().stream().map(Ingredient::fromForge).collect(Collectors.toList());
    }

    @Override
    public boolean isDynamic()
    {
        return forgeRecipe.isDynamic();
    }

    @Override
    public String getGroup()
    {
        return forgeRecipe.getGroup();
    }

    @Override
    public IRecipe setRegistryName(final IIdentifier name)
    {
        forgeRecipe = forgeRecipe.setRegistryName(Identifier.asForge(name));
        return this;
    }

    @Override
    public IIdentifier getRegistryName()
    {
        return Identifier.fromForge(forgeRecipe.getRegistryName());
    }

    @Override
    public Class<IRecipe> getRegistryType()
    {
        //Note this might break under certain cituations. But I can not come up with something better.
        return IRecipe.class;
    }

    private net.minecraft.item.crafting.IRecipe getForgeRecipe()
    {
        return forgeRecipe;
    }

    public static IRecipe fromForge(net.minecraft.item.crafting.IRecipe recipe)
    {
        if (recipe instanceof IRecipe)
            return (IRecipe) recipe;

        return new Recipe(recipe);
    }

    public static net.minecraft.item.crafting.IRecipe asForge(IRecipe recipe)
    {
        if (recipe instanceof net.minecraft.item.crafting.IRecipe)
            return (net.minecraft.item.crafting.IRecipe) recipe;

        return ((Recipe) recipe).getForgeRecipe();
    }
}
