package com.ldtteam.jvoxelizer.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;

public interface IPlayerGameEventProvider
{

    IPlayerGameEvent.ILoggedInEvent provideLoggedInEvent(IPlayerEntity playerEntity);

    IPlayerGameEvent.ILoggedOutEvent provideLoggedOutEvent(IPlayerEntity playerEntity);
}
