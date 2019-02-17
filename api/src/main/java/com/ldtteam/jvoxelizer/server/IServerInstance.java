package com.ldtteam.jvoxelizer.server;

import com.ldtteam.jvoxelizer.server.manager.IPlayerManager;

public interface IServerInstance
{

    IPlayerManager getPlayerManager();
}
