package com.ldtteam.jvoxelizer.launcher.forge_1_13.event;

import com.ldtteam.jvoxelizer.event.IEvent;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;

public class Event implements IEvent, IForgeJVoxelizerWrapper
{

    private final net.minecraftforge.eventbus.api.Event forgeEvent;

    public Event(final net.minecraftforge.eventbus.api.Event forgeEvent) {this.forgeEvent = forgeEvent;}

    private net.minecraftforge.eventbus.api.Event getForgeEvent()
    {
        return forgeEvent;
    }

    public static IEvent fromForge(net.minecraftforge.eventbus.api.Event event)
    {
        if (event instanceof IEvent)
            return (IEvent) event;

        if (event == null)
            return null;

        return new Event(event);
    }

    public static net.minecraftforge.eventbus.api.Event asForge(IEvent event)
    {
        if (event instanceof net.minecraftforge.eventbus.api.Event)
            return (net.minecraftforge.eventbus.api.Event) event;

        if (event == null)
            return null;

        if (!(event instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("Event is not a wrapper");

        return ((IForgeJVoxelizerWrapper) event).getForgeInstance();
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeEvent();
    }
}
