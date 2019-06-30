package com.ldtteam.jvoxelizer.util.facing;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IFacingProviderHolder extends AbstractHolder<IFacingProvider> implements IFacingProvider
{
    private static IFacingProviderHolder ourInstance = new IFacingProviderHolder();

    public static IFacingProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IFacingProviderHolder()
    {
        super(IFacing.class.getName());
    }

    @Override
    public IFacing getNorth()
    {
        return getProvider().getNorth();
    }

    @Override
    public IFacing getSouth()
    {
        return getProvider().getSouth();
    }

    @Override
    public IFacing getWest()
    {
        return getProvider().getWest();
    }

    @Override
    public IFacing getEast()
    {
        return getProvider().getEast();
    }

    @Override
    public IFacing getUp()
    {
        return getProvider().getUp();
    }

    @Override
    public IFacing getDown()
    {
        return getProvider().getDown();
    }

    @Override
    public IFacing getNone()
    {
        return getProvider().getNone();
    }
}