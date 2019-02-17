package com.ldtteam.jvoxelizer.event.manager;

import com.ldtteam.jvoxelizer.event.IEvent;

public interface IEventManagerProvider
{

    void post(IEvent event);
}
