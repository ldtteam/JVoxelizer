package com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.item;

import com.ldtteam.jvoxelizer.entity.item.IItemStackEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.Entity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.ItemStack;
import net.minecraft.entity.item.EntityItem;
import org.jetbrains.annotations.NotNull;

public class ItemStackEntity extends Entity implements IItemStackEntity
{
    /**
     * The forge entity for the itemstack.
     */
    private EntityItem forgeItemEntity;

    /**
     * The voxel Itemstack
     */
    private ItemStack voxelStack;

    public ItemStackEntity(@NotNull final EntityItem forgeItemEntity)
    {
        super(forgeItemEntity);
        this.forgeItemEntity = forgeItemEntity;
        voxelStack = new ItemStack(forgeItemEntity.getItem());
    }

    @Override
    public float getHoverStart()
    {
        return forgeItemEntity.hoverStart;
    }

    @Override
    public IItemStackEntity setHoverStart(final float hoverStart)
    {
        forgeItemEntity.hoverStart = hoverStart;
        return this;
    }

    @Override
    public int getLifeSpan()
    {
        return forgeItemEntity.lifespan;
    }

    @Override
    public IItemStackEntity setLifeSpan(final int lifeSpan)
    {
        forgeItemEntity.lifespan = lifeSpan;
        return this;
    }

    @Override
    public IItemStackEntity setAgeToCreativeDespawnTime()
    {
        forgeItemEntity.setAgeToCreativeDespawnTime();
        return this;
    }

    @Override
    public String getName()
    {
        return forgeItemEntity.getName();
    }

    @Override
    public IItemStack getItemStack()
    {
        return voxelStack;
    }

    @Override
    public IItemStackEntity setItem(final IItemStack stack)
    {
        forgeItemEntity.setItem(((ItemStack) stack).getForgeItem());
        return this;
    }
}
