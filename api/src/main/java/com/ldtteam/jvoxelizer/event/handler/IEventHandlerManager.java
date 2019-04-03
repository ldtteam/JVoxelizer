package com.ldtteam.jvoxelizer.event.handler;

import java.util.function.Consumer;

public interface IEventHandlerManager
{

    static <T> void registerHandler(Class<T> handledType, Consumer<T> handler)
    {
        IEventHandlerManagerProviderHolder.getInstance().registerHandler(handledType, handler);
    }
}
