package com.ldtteam.jvoxelizer.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;

public interface IPlayerEntityEventProvider
{

    IPlayerEntityEvent.IContainerEvent.IOpen provideContainerOpenEvent(IPlayerEntity playerEntity, IContainer<?> inventoryContainer);

    IPlayerEntityEvent.IContainerEvent.IClose provideContainerCloseEvent(IPlayerEntity player, IContainer<?> container);
}
