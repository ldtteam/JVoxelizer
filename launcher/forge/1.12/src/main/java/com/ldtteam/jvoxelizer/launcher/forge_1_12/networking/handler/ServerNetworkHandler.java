package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.handler;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.MultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.networking.handler.IServerNetworkHandler;
import net.minecraft.network.NetHandlerPlayServer;

public class ServerNetworkHandler implements IServerNetworkHandler
{
    private NetHandlerPlayServer handler;

    private ServerNetworkHandler(final NetHandlerPlayServer handler)
    {
        this.handler = handler;
    }

    @Override
    public IMultiplayerPlayerEntity getPlayer()
    {
        return MultiplayerPlayerEntity.fromForge(handler.player);
    }

    public static NetHandlerPlayServer asForge(final IServerNetworkHandler handler)
    {
        if (handler instanceof NetHandlerPlayServer)
            return (NetHandlerPlayServer) handler;

        return ((ServerNetworkHandler) handler).handler;
    }

    public static IServerNetworkHandler fromForge(final NetHandlerPlayServer handler)
    {
        if (handler instanceof IServerNetworkHandler)
            return (IServerNetworkHandler) handler;

        return new ServerNetworkHandler(handler);
    }
}
