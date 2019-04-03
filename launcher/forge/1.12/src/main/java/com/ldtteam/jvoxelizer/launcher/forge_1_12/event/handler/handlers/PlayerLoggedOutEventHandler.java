package com.ldtteam.jvoxelizer.launcher.forge_1_12.event.handler.handlers;

import com.google.common.eventbus.Subscribe;
import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerGameEvent;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.common.gameevent.event.player.PlayerGameEvent;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.event.handler.EventHandlerManagerProvider;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.function.Consumer;

public class PlayerLoggedOutEventHandler
{

    @SubscribeEvent
    public void onFired(PlayerEvent.PlayerLoggedOutEvent playerLoggedOutEvent)
    {
        EventHandlerManagerProvider.getInstance().getHandlers().get(IPlayerGameEvent.ILoggedOutEvent.class).forEach(handler -> {
            final Consumer<IPlayerGameEvent.ILoggedOutEvent> typedHandler = (Consumer<IPlayerGameEvent.ILoggedOutEvent>) handler;

            typedHandler.accept(PlayerGameEvent.LoggedOutEvent.fromForge(playerLoggedOutEvent));
        });
    }

}
