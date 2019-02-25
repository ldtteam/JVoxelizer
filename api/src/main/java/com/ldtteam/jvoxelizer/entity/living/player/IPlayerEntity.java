package com.ldtteam.jvoxelizer.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.IContainerListener;
import com.ldtteam.jvoxelizer.inventory.IInventoryPlayer;

public interface IPlayerEntity extends ILivingBaseEntity, IContainerListener
{

    IInventoryPlayer getInventory();

    IContainer<?> getOpenContainer();

    IPlayerEntity setOpenContainer(IContainer<?> container);
}
