package com.ldtteam.jvoxelizer.event.handler;

import com.ldtteam.jvoxelizer.event.IEvent;

import java.util.function.Consumer;

public interface IEventHandlerManagerProvider
{

    <T extends IEvent> void registerHandler(Class<T> handledType, Consumer<T> handler);
}
