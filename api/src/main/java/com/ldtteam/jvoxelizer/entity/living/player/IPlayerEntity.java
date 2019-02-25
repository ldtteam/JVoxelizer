package com.ldtteam.jvoxelizer.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.inventory.IInventoryContainer;
import com.ldtteam.jvoxelizer.inventory.IInventoryPlayer;

public interface IPlayerEntity extends ILivingBaseEntity
{

    IInventoryPlayer getInventory();

    IInventoryContainer getOpenContainer();

    IPlayerEntity setOpenContainer(IInventoryContainer container);
}
