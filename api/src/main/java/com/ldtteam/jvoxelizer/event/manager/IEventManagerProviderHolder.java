package com.ldtteam.jvoxelizer.event.manager;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.event.IEvent;

final class IEventManagerProviderHolder extends AbstractHolder<IEventManagerProvider> implements IEventManagerProvider
{
    private static IEventManagerProviderHolder ourInstance = new IEventManagerProviderHolder();

    public static IEventManagerProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IEventManagerProviderHolder()
    {
        super(IEventManager.class.getName());
    }

    @Override
    public void post(final IEvent event)
    {
        getProvider().post(event);
    }
}