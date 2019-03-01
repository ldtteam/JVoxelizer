package com.ldtteam.jvoxelizer.client.mouse;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IMouseProviderHolder extends AbstractHolder<IMouseProvider> implements IMouseProvider
{
    private static IMouseProviderHolder ourInstance = new IMouseProviderHolder();

    public static IMouseProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IMouseProviderHolder()
    {
        super(IMouse.class.getName());
    }

    @Override
    public double provideX()
    {
        return getProvider().provideX();
    }

    @Override
    public double provideY()
    {
        return getProvider().provideY();
    }

    @Override
    public int provideDWheel()
    {
        return getProvider().provideDWheel();
    }

    @Override
    public int provideEventButton()
    {
        return getProvider().provideEventButton();
    }
}