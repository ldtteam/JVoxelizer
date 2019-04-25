package com.ldtteam.jvoxelizer.launcher.forge_1_13.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerGameEvent;
import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerGameEventProvider;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player.PlayerEntity;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerGameEventProvider implements IPlayerGameEventProvider
{
    private static PlayerGameEventProvider ourInstance = new PlayerGameEventProvider();

    public static PlayerGameEventProvider getInstance()
    {
        return ourInstance;
    }

    private PlayerGameEventProvider()
    {
    }

    @Override
    public IPlayerGameEvent.ILoggedInEvent provideLoggedInEvent(final IPlayerEntity playerEntity)
    {
        return PlayerGameEvent.LoggedInEvent.fromForge(new PlayerEvent.PlayerLoggedInEvent(PlayerEntity.asForge(playerEntity)));
    }

    @Override
    public IPlayerGameEvent.ILoggedOutEvent provideLoggedOutEvent(final IPlayerEntity playerEntity)
    {
        return PlayerGameEvent.LoggedOutEvent.fromForge(new PlayerEvent.PlayerLoggedOutEvent(PlayerEntity.asForge(playerEntity)));
    }
}
