package com.ldtteam.jvoxelizer.util.math.coordinate.entity;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class EntityCoordinateProviderHolder extends AbstractHolder<IEntityCoordinateProvider> implements IEntityCoordinateProvider
{
    private static EntityCoordinateProviderHolder
      ourInstance = new EntityCoordinateProviderHolder();

    public static EntityCoordinateProviderHolder getInstance()
    {
        return ourInstance;
    }

    private EntityCoordinateProviderHolder()
    {
        super(IEntityCoordinate.class.getName());
    }

    @Override
    public IEntityCoordinate provide(final double x, final double y, final double z)
    {
        return getProvider().provide(x, y, z);
    }
}
