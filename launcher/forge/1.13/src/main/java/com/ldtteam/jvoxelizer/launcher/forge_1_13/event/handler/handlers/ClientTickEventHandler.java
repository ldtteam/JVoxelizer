package com.ldtteam.jvoxelizer.launcher.forge_1_13.event.handler.handlers;

import com.ldtteam.jvoxelizer.common.gameevent.event.ITickEvent;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.event.handler.EventHandlerManagerProvider;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.function.Consumer;

public class ClientTickEventHandler
{
    public void onFired(TickEvent.ClientTickEvent clientTickEvent)
    {
        EventHandlerManagerProvider.getInstance().getHandlers().get(ITickEvent.IClientTickEvent.class).forEach(handler -> {
            final Consumer<ITickEvent.IClientTickEvent> typedHandler = (Consumer<ITickEvent.IClientTickEvent>) handler;

            typedHandler.accept(com.ldtteam.jvoxelizer.launcher.forge_1_13.common.gameevent.event.TickEvent.Client.fromForge(clientTickEvent));
        });
    }
}
