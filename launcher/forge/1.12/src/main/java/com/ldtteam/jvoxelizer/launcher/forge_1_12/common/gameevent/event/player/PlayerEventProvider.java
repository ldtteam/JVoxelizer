package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerEvent;
import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerEventProvider;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;

public class PlayerEventProvider implements IPlayerEventProvider
{
    private static PlayerEventProvider ourInstance = new PlayerEventProvider();

    public static PlayerEventProvider getInstance()
    {
        return ourInstance;
    }

    private PlayerEventProvider()
    {
    }

    @Override
    public IPlayerEvent.IPlayerContainerEvent.IOpen provideContainerOpenEvent(
      final IPlayerEntity playerEntity, final IContainer<?> inventoryContainer)
    {
        return new PlayerEvent.PlayerContainerEvent.Open(playerEntity, inventoryContainer);
    }
}
