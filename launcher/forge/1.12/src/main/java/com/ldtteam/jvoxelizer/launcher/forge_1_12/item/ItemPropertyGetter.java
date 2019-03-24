package com.ldtteam.jvoxelizer.launcher.forge_1_12.item;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.item.IItemPropertyGetter;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.Dimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.LivingBaseEntity;

public class ItemPropertyGetter implements IItemPropertyGetter
{
    private net.minecraft.item.IItemPropertyGetter propertyGetter;

    private ItemPropertyGetter(final net.minecraft.item.IItemPropertyGetter propertyGetter)
    {
        this.propertyGetter = propertyGetter;
    }

    @Override
    public float apply(
      final IItemStack stack, final IDimension worldIn, final ILivingBaseEntity entityIn)
    {
        return propertyGetter.apply(ItemStack.asForge(stack), Dimension.asForge(worldIn), LivingBaseEntity.asForge(entityIn));
    }

    public static net.minecraft.item.IItemPropertyGetter asForge(final IItemPropertyGetter itemPropertyGetter)
    {
        if (itemPropertyGetter instanceof net.minecraft.item.IItemPropertyGetter)
            return (net.minecraft.item.IItemPropertyGetter) itemPropertyGetter;

        return ((ItemPropertyGetter) itemPropertyGetter).propertyGetter;
    }

    public static IItemPropertyGetter fromForge(final net.minecraft.item.IItemPropertyGetter itemPropertyGetter)
    {
        if (itemPropertyGetter instanceof IItemPropertyGetter)
            return (IItemPropertyGetter) itemPropertyGetter;

        return new ItemPropertyGetter(itemPropertyGetter);
    }
}
