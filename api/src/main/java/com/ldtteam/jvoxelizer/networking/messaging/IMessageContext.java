package com.ldtteam.jvoxelizer.networking.messaging;

import com.ldtteam.jvoxelizer.networking.handler.IServerNetworkHandler;

public interface IMessageContext
{

    IServerNetworkHandler getServerHandler();
}
