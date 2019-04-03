package com.ldtteam.jvoxelizer.launcher.forge_1_12.event.manager;

import com.ldtteam.jvoxelizer.event.IEvent;
import com.ldtteam.jvoxelizer.event.manager.IEventManagerProvider;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.event.Event;
import net.minecraftforge.common.MinecraftForge;

public class EventManagerProvider implements IEventManagerProvider
{
    private static EventManagerProvider ourInstance = new EventManagerProvider();

    public static EventManagerProvider getInstance()
    {
        return ourInstance;
    }

    private EventManagerProvider()
    {
    }

    @Override
    public void post(final IEvent event)
    {
        MinecraftForge.EVENT_BUS.post(Event.asForge(event));
    }
}
