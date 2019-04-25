package com.ldtteam.jvoxelizer.networking.messaging;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;

public interface IMessageContext
{

    IMultiplayerPlayerEntity getSendingPlayer();
}
