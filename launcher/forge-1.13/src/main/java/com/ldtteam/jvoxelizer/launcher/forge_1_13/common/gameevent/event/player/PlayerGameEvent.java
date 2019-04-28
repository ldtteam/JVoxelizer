package com.ldtteam.jvoxelizer.launcher.forge_1_13.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerGameEvent;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.event.Event;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerGameEvent extends Event implements IPlayerGameEvent
{

    private final PlayerEvent playerEvent;

    public PlayerGameEvent(final PlayerEvent playerEvent) {
        super(playerEvent);
        this.playerEvent = playerEvent;
    }

    @Override
    public IPlayerEntity getPlayerEntity()
    {
        return PlayerEntity.fromForge(playerEvent.getPlayer());
    }
    
    public static class LoggedInEvent extends PlayerGameEvent implements ILoggedInEvent
    {
        public LoggedInEvent(final PlayerEvent.PlayerLoggedInEvent playerEvent)
        {
            super(playerEvent);
        }
        
        public static ILoggedInEvent fromForge(PlayerEvent.PlayerLoggedInEvent playerLoggedInEvent)
        {
            if (playerLoggedInEvent instanceof ILoggedInEvent)
                return (ILoggedInEvent) playerLoggedInEvent;
            
            if (playerLoggedInEvent == null)
                return null;
            
            return new LoggedInEvent(playerLoggedInEvent);
        }
        
        public static PlayerEvent.PlayerLoggedInEvent asForge(ILoggedInEvent event)
        {
            if (event instanceof PlayerEvent.PlayerLoggedInEvent)
                return (PlayerEvent.PlayerLoggedInEvent) event;
            
            if (event == null)
                return null;
            
            if(!(event instanceof IForgeJVoxelizerWrapper))
                throw new IllegalArgumentException("Event is not a wrapper");
            
            return ((IForgeJVoxelizerWrapper) event).getForgeInstance();
        }
    }

    public static class LoggedOutEvent extends PlayerGameEvent implements ILoggedOutEvent
    {
        public LoggedOutEvent(final PlayerEvent.PlayerLoggedOutEvent playerEvent)
        {
            super(playerEvent);
        }

        public static ILoggedOutEvent fromForge(PlayerEvent.PlayerLoggedOutEvent playerLoggedOutEvent)
        {
            if (playerLoggedOutEvent instanceof ILoggedOutEvent)
                return (ILoggedOutEvent) playerLoggedOutEvent;

            if (playerLoggedOutEvent == null)
                return null;

            return new LoggedOutEvent(playerLoggedOutEvent);
        }

        public static PlayerEvent.PlayerLoggedOutEvent asForge(ILoggedOutEvent event)
        {
            if (event instanceof PlayerEvent.PlayerLoggedOutEvent)
                return (PlayerEvent.PlayerLoggedOutEvent) event;

            if (event == null)
                return null;

            if(!(event instanceof IForgeJVoxelizerWrapper))
                throw new IllegalArgumentException("Event is not a wrapper");

            return ((IForgeJVoxelizerWrapper) event).getForgeInstance();
        }
    }
}
