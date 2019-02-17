package com.ldtteam.jvoxelizer.inventory;

import com.ldtteam.jvoxelizer.entity.player.IPlayerEntity;

public interface IInventoryContainer
{

    IInventoryContainer setWindowId(int windowId);

    IInventoryContainer addListener(IPlayerEntity playerEntity);
}
