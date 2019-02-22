package com.ldtteam.jvoxelizer.server.manager;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;

import java.util.UUID;

public interface IPlayerManager
{

    IMultiplayerPlayerEntity getById(UUID id);
}
