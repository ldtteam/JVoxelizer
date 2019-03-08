package com.ldtteam.jvoxelizer.entity;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.dimension.IDimension;

import java.util.UUID;

/**
 * Holds the logic for creating new entities in different situations.
 */
final class IEntityProviderHolder extends AbstractHolder<IEntityProvider> implements IEntityProvider
{
    private static IEntityProviderHolder ourInstance = new IEntityProviderHolder();

    public static IEntityProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IEntityProviderHolder()
    {
        super(IEntity.class.getName());
    }

    @Override
    public IEntity provide(final IDimension<?> dimension)
    {
        return getProvider().provide(dimension);
    }

    @Override
    public IEntity provide(final UUID id)
    {
        return getProvider().provide(id);
    }

    @Override
    public IEntity provide()
    {
        return getProvider().provide();
    }
}
