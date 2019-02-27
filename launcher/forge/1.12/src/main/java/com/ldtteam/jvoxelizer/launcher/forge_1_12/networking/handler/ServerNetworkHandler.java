package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.handler;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.MultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.networking.handler.IServerNetworkHandler;
import net.minecraft.network.NetHandlerPlayServer;

public class ServerNetworkHandler implements IServerNetworkHandler
{
    private NetHandlerPlayServer handler;

    public ServerNetworkHandler(final NetHandlerPlayServer handler)
    {
        this.handler = handler;
    }

    @Override
    public IMultiplayerPlayerEntity getPlayer()
    {
        return new MultiplayerPlayerEntity(handler.player);
    }
}
