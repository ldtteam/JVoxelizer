package com.ldtteam.jvoxelizer.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.event.IEvent;

public interface IPlayerGameEvent extends IEvent
{
    IPlayerEntity getPlayerEntity();

    interface ILoggedInEvent extends IPlayerGameEvent
    {
        static ILoggedInEvent create(IPlayerEntity playerEntity)
        {
            return IPlayerGameEventProviderHolder.getInstance().provideLoggedInEvent(playerEntity);
        }
    }

    interface ILoggedOutEvent extends IPlayerGameEvent
    {
        static ILoggedOutEvent create(IPlayerEntity playerEntity)
        {
            return IPlayerGameEventProviderHolder.getInstance().provideLoggedOutEvent(playerEntity);
        }
    }
}
