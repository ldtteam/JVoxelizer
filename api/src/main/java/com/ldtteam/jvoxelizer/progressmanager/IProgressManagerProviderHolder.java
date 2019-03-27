package com.ldtteam.jvoxelizer.progressmanager;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IProgressManagerProviderHolder extends AbstractHolder<IProgressManagerProvider> implements IProgressManagerProvider
{
    private static IProgressManagerProviderHolder ourInstance = new IProgressManagerProviderHolder();

    public static IProgressManagerProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IProgressManagerProviderHolder()
    {
        super(IProgressManager.class.getName());
    }

    @Override
    public IProgressBar push(final String name, final int size)
    {
        return getProvider().push(name, size);
    }

    @Override
    public void pop(final IProgressBar bar)
    {
        getProvider().pop(bar);
    }
}