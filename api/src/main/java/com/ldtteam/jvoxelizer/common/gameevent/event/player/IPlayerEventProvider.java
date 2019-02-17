package com.ldtteam.jvoxelizer.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.entity.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IInventoryContainer;

public interface IPlayerEventProvider
{

    IPlayerEvent.IPlayerContainerEvent.IOpen provideContainerOpenEvent(IPlayerEntity playerEntity, IInventoryContainer inventoryContainer);
}
