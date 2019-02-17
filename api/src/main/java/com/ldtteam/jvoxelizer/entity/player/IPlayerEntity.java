package com.ldtteam.jvoxelizer.entity.player;

import com.ldtteam.jvoxelizer.entity.IEntity;
import com.ldtteam.jvoxelizer.inventory.IInventoryContainer;

public interface IPlayerEntity extends IEntity
{

    IInventoryContainer getOpenContainer();

    IPlayerEntity setOpenContainer(IInventoryContainer container);
}
