package com.ldtteam.jvoxelizer.networking.utils.target;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.util.math.coordinate.entity.IEntityCoordinate;
import com.ldtteam.jvoxelizer.world.IDimension;

final class INetworkTargetPointProviderHolder extends AbstractHolder<INetworkTargetPointProvider> implements INetworkTargetPointProvider
{
    private static INetworkTargetPointProviderHolder ourInstance = new INetworkTargetPointProviderHolder();

    public static INetworkTargetPointProviderHolder getInstance()
    {
        return ourInstance;
    }

    private INetworkTargetPointProviderHolder()
    {
        super(INetworkTargetPoint.class.getName());
    }

    @Override
    public INetworkTargetPoint provide(final IEntityCoordinate target, final double range, final IDimension dimension)
    {
        return getProvider().provide(target, range, dimension);
    }
}
