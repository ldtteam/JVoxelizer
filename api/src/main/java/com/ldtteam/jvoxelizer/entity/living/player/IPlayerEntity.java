package com.ldtteam.jvoxelizer.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.inventory.IInventoryContainer;

public interface IPlayerEntity extends ILivingBaseEntity
{

    IInventoryContainer getOpenContainer();

    IPlayerEntity setOpenContainer(IInventoryContainer container);
}
