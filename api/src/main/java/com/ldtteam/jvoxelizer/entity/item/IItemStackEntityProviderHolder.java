package com.ldtteam.jvoxelizer.entity.item;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import com.ldtteam.jvoxelizer.world.IDimension;

public class IItemStackEntityProviderHolder extends AbstractHolder<IItemStackEntityProvider> implements IItemStackEntityProvider
{
    private static IItemStackEntityProviderHolder ourInstance = new IItemStackEntityProviderHolder();

    public static IItemStackEntityProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IItemStackEntityProviderHolder()
    {
        super(IItemStackEntity.class.getName());
    }

    @Override
    public IItemStackEntity provide(final IDimension dimension, final IEntityCoordinate coordinate)
    {
        return getProvider().provide(dimension, coordinate);
    }

    @Override
    public IItemStackEntity provide(final IDimension dimension, final IEntityCoordinate coordinate, final IItemStack stack)
    {
        return getProvider().provide(dimension, coordinate, stack);
    }
}
