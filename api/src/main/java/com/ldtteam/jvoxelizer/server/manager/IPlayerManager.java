package com.ldtteam.jvoxelizer.server.manager;

import com.ldtteam.jvoxelizer.entity.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.entity.player.IPlayerEntity;

import java.util.UUID;

public interface IPlayerManager
{

    IMultiplayerPlayerEntity getById(UUID id);
}
