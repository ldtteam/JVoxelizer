package com.ldtteam.jvoxelizer.launcher.forge_1_13.event.handler;

import com.google.common.collect.Maps;
import com.ldtteam.jvoxelizer.common.gameevent.event.ITickEvent;
import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerGameEvent;
import com.ldtteam.jvoxelizer.event.IEvent;
import com.ldtteam.jvoxelizer.event.handler.IEventHandlerManagerProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.event.handler.handlers.ClientTickEventHandler;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.event.handler.handlers.PlayerLoggedOutEventHandler;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.event.handler.handlers.ServerTickEventHandler;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventHandlerManagerProvider implements IEventHandlerManagerProvider
{
    private static EventHandlerManagerProvider ourInstance = new EventHandlerManagerProvider();

    public static EventHandlerManagerProvider getInstance()
    {
        return ourInstance;
    }

    private final Map<Class<?>, List<Consumer<? extends IEvent>>> handlers = Maps.newHashMap();

    private final Map<Class<?>, Object> knownEventHandlers = Maps.newHashMap();

    private EventHandlerManagerProvider()
    {
        knownEventHandlers.put(IPlayerGameEvent.ILoggedOutEvent.class, new PlayerLoggedOutEventHandler());
        knownEventHandlers.put(ITickEvent.IClientTickEvent.class, new ClientTickEventHandler());
        knownEventHandlers.put(ITickEvent.IServerTickEvent.class, new ServerTickEventHandler());
    }

    @Override
    public <T extends IEvent> void registerHandler(final Class<T> handledType, final Consumer<T> handler)
    {
        if (knownEventHandlers.containsKey(handledType))
            MinecraftForge.EVENT_BUS.register(knownEventHandlers.remove(handledType));

        handlers.putIfAbsent(handledType, new ArrayList<>());
        handlers.get(handledType).add(handler);
    }

    public Map<Class<?>, List<Consumer<? extends IEvent>>> getHandlers()
    {
        return handlers;
    }
}
