package com.ldtteam.jvoxelizer.event.handler;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;
import com.ldtteam.jvoxelizer.event.IEvent;

import java.util.function.Consumer;

final class IEventHandlerManagerProviderHolder extends AbstractHolder<IEventHandlerManagerProvider> implements IEventHandlerManagerProvider
{
    private static IEventHandlerManagerProviderHolder ourInstance = new IEventHandlerManagerProviderHolder();

    public static IEventHandlerManagerProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IEventHandlerManagerProviderHolder()
    {
        super(IEventHandlerManager.class.getName());
    }

    @Override
    public <T extends IEvent> void registerHandler(final Class<T> handledType, final Consumer<T> handler)
    {
        getProvider().registerHandler(handledType, handler);
    }
}