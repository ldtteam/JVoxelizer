package com.ldtteam.jvoxelizer.launcher.forge_1_12.item.crafting;

import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.item.crafting.IIngredient;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;
import it.unimi.dsi.fastutil.ints.IntList;

import java.util.Arrays;

public class Ingredient implements IIngredient, IForgeJVoxelizerWrapper
{
    private final net.minecraft.item.crafting.Ingredient forgeIngredient;

    private Ingredient(final net.minecraft.item.crafting.Ingredient forgeIngredient) {this.forgeIngredient = forgeIngredient;}

    @Override
    public IItemStack[] getMatchingStacks()
    {
        return Arrays.stream(forgeIngredient.getMatchingStacks()).map(ItemStack::fromForge).toArray(IItemStack[]::new);
    }

    @Override
    public boolean apply(final IItemStack p_apply_1_)
    {
        return forgeIngredient.apply(ItemStack.asForge(p_apply_1_));
    }

    @Override
    public IntList getValidItemStacksPacked()
    {
        return forgeIngredient.getValidItemStacksPacked();
    }

    @Override
    public boolean isSimple()
    {
        return forgeIngredient.isSimple();
    }

    private net.minecraft.item.crafting.Ingredient getForgeIngredient()
    {
        return forgeIngredient;
    }

    public static IIngredient fromForge(net.minecraft.item.crafting.Ingredient ingredient)
    {
        return new Ingredient(ingredient);
    }

    public static net.minecraft.item.crafting.Ingredient asForge(IIngredient ingredient)
    {
        if (!(ingredient instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("Ingredient is not a wrapper");

        return ((IForgeJVoxelizerWrapper) ingredient).getForgeInstance();
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeIngredient();
    }
}
