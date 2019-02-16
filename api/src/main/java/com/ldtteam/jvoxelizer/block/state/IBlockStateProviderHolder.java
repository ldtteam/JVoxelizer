package com.ldtteam.jvoxelizer.block.state;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IBlockStateProviderHolder extends AbstractHolder<IBlockStateProvider> implements IBlockStateProvider
{
    private static IBlockStateProviderHolder ourInstance = new IBlockStateProviderHolder();

    public static IBlockStateProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IBlockStateProviderHolder()
    {
        super(IBlockState.class.getName());
    }

    @Override
    public IBlockState provide()
    {
        return getProvider().provide();
    }
}
