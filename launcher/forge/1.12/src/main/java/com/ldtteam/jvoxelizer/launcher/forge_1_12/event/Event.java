package com.ldtteam.jvoxelizer.launcher.forge_1_12.event;

import com.ldtteam.jvoxelizer.event.IEvent;

public class Event implements IEvent
{
    private net.minecraftforge.fml.common.eventhandler.Event event;

    public Event(final net.minecraftforge.fml.common.eventhandler.Event event)
    {
        this.event = event;
    }
}
