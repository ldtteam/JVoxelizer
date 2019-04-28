package com.ldtteam.jvoxelizer.launcher.forge_1_12.event;

import com.ldtteam.jvoxelizer.event.IEvent;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;

public class Event implements IEvent, IForgeJVoxelizerWrapper
{

    private final net.minecraftforge.fml.common.eventhandler.Event forgeEvent;

    public Event(final net.minecraftforge.fml.common.eventhandler.Event forgeEvent) {this.forgeEvent = forgeEvent;}

    private net.minecraftforge.fml.common.eventhandler.Event getForgeEvent()
    {
        return forgeEvent;
    }

    public static IEvent fromForge(net.minecraftforge.fml.common.eventhandler.Event event)
    {
        if (event instanceof IEvent)
            return (IEvent) event;

        if (event == null)
            return null;

        return new Event(event);
    }

    public static net.minecraftforge.fml.common.eventhandler.Event asForge(IEvent event)
    {
        if (event instanceof net.minecraftforge.fml.common.eventhandler.Event)
            return (net.minecraftforge.fml.common.eventhandler.Event) event;

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
