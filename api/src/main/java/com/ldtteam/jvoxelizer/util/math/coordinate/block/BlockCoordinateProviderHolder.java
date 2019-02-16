package com.ldtteam.jvoxelizer.util.math.coordinate.block;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class BlockCoordinateProviderHolder extends AbstractHolder<IBlockCoordinateProvider> implements IBlockCoordinateProvider
{
    private static BlockCoordinateProviderHolder ourInstance = new BlockCoordinateProviderHolder();

    public static BlockCoordinateProviderHolder getInstance()
    {
        return ourInstance;
    }

    private BlockCoordinateProviderHolder()
    {
        super(IBlockCoordinate.class.getName());
    }

    @Override
    public IBlockCoordinate provide(final int x, final int y, final int z)
    {
        return getProvider().provide(x, y, z);
    }
}
