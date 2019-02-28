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

    public ItemPropertyGetter(final net.minecraft.item.IItemPropertyGetter propertyGetter)
    {
        this.propertyGetter = propertyGetter;
    }

    @Override
    public float apply(
      final IItemStack stack, final IDimension worldIn, final ILivingBaseEntity entityIn)
    {
        return propertyGetter.apply(((ItemStack) stack).getForgeItem(), ((Dimension)worldIn).getForgeWorld(), ((LivingBaseEntity)entityIn).getForgeEntity());
    }

    /**
     * Getter for the wrapped forge class.
     * @return the net.minecraft.item.IItemPropertyGetter.
     */
    public net.minecraft.item.IItemPropertyGetter getForgePropertyGetter()
    {
        return this.propertyGetter;
    }
}
