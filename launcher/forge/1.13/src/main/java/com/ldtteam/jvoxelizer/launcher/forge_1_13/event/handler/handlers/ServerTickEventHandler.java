package com.ldtteam.jvoxelizer.launcher.forge_1_13.event.handler.handlers;

import com.ldtteam.jvoxelizer.common.gameevent.event.ITickEvent;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.event.handler.EventHandlerManagerProvider;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.function.Consumer;

public class ServerTickEventHandler
{
    public void onFired(TickEvent.ServerTickEvent serverTickEvent)
    {
        EventHandlerManagerProvider.getInstance().getHandlers().get(ITickEvent.IServerTickEvent.class).forEach(handler -> {
            final Consumer<ITickEvent.IServerTickEvent> typedHandler = (Consumer<ITickEvent.IServerTickEvent>) handler;

            typedHandler.accept(com.ldtteam.jvoxelizer.launcher.forge_1_13.common.gameevent.event.TickEvent.Server.fromForge(serverTickEvent));
        });
    }
}
