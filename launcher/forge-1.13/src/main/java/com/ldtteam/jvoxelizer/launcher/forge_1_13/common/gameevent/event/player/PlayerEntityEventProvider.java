package com.ldtteam.jvoxelizer.launcher.forge_1_13.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerEntityEvent;
import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerEntityEventProvider;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.Container;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;

public class PlayerEntityEventProvider implements IPlayerEntityEventProvider
{
    private static PlayerEntityEventProvider ourInstance = new PlayerEntityEventProvider();

    public static PlayerEntityEventProvider getInstance()
    {
        return ourInstance;
    }

    private PlayerEntityEventProvider()
    {
    }

    @Override
    public IPlayerEntityEvent.IContainerEvent.IOpen provideContainerOpenEvent(
      final IPlayerEntity playerEntity, final IContainer<?> inventoryContainer)
    {
        return PlayerEntityEvent.ContainerEvent.Open.fromForge(new PlayerContainerEvent.Open(PlayerEntity.asForge(playerEntity), Container
                                                                                                                              .asForge(inventoryContainer)));
    }

    @Override
    public IPlayerEntityEvent.IContainerEvent.IClose provideContainerCloseEvent(final IPlayerEntity player, final IContainer<?> container)
    {
        return PlayerEntityEvent.ContainerEvent.Close.fromForge(new PlayerContainerEvent.Close(PlayerEntity.asForge(player), Container
                                                                                                                          .asForge(container)));
    }
}
