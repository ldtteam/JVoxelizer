package com.ldtteam.jvoxelizer.event.manager;

import com.ldtteam.jvoxelizer.event.IEvent;

public interface IEventManager
{
    static void post(IEvent event)
    {
        IEventManagerProviderHolder.getInstance().post(event);
    }
}
