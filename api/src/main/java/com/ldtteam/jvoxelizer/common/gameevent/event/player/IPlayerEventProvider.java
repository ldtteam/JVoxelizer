package com.ldtteam.jvoxelizer.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;

public interface IPlayerEventProvider
{

    IPlayerEntityEvent.IPlayerContainerEvent.IOpen provideContainerOpenEvent(IPlayerEntity playerEntity, IContainer<?> inventoryContainer);

    IPlayerEntityEvent.IPlayerContainerEvent.IClose provideContainerCloseEvent(IPlayerEntity player, IContainer<?> container);
}
