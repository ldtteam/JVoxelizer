package com.ldtteam.jvoxelizer.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;

public interface IPlayerEventProvider
{

    IPlayerEvent.IPlayerContainerEvent.IOpen provideContainerOpenEvent(IPlayerEntity playerEntity, IContainer<?> inventoryContainer);
}
