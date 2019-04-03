package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerEntityEvent;
import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerEventProvider;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.inventory.Container;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;

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
    public IPlayerEntityEvent.IPlayerContainerEvent.IOpen provideContainerOpenEvent(
      final IPlayerEntity playerEntity, final IContainer<?> inventoryContainer)
    {
        return PlayerEvent.PlayerContainerEvent.Open.fromForge(new PlayerContainerEvent.Open(PlayerEntity.asForge(playerEntity), Container.asForge(inventoryContainer)));
    }

    @Override
    public IPlayerEntityEvent.IPlayerContainerEvent.IClose provideContainerCloseEvent(final IPlayerEntity player, final IContainer<?> container)
    {
        return PlayerEvent.PlayerContainerEvent.Close.fromForge(new PlayerContainerEvent.Close(PlayerEntity.asForge(player), Container.asForge(container)));
    }
}
