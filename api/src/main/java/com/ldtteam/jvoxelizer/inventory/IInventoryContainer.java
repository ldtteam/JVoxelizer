package com.ldtteam.jvoxelizer.inventory;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;

public interface IInventoryContainer
{

    IInventoryContainer setWindowId(int windowId);

    IInventoryContainer addListener(IPlayerEntity playerEntity);
}
