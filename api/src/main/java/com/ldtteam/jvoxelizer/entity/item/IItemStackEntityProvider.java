package com.ldtteam.jvoxelizer.entity.item;

import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import com.ldtteam.jvoxelizer.dimension.IDimension;

/**
 * Provide that handles the logic for creating itemstack entities.
 */
public interface IItemStackEntityProvider
{

    IItemStackEntity provide(final IDimension dimension, final IEntityCoordinate coordinate);

    IItemStackEntity provide(final IDimension dimension, final IEntityCoordinate coordinate, final IItemStack stack);
}
