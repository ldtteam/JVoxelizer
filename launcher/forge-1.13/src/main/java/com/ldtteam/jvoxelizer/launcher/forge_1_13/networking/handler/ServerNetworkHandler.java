package com.ldtteam.jvoxelizer.launcher.forge_1_13.networking.handler;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player.MultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.networking.handler.IServerNetworkHandler;
import net.minecraft.network.NetHandlerPlayServer;

public class ServerNetworkHandler implements IServerNetworkHandler, IForgeJVoxelizerWrapper
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

    private NetHandlerPlayServer getHandler()
    {
        return handler;
    }

    public static NetHandlerPlayServer asForge(final IServerNetworkHandler handler)
    {
        if (handler instanceof NetHandlerPlayServer)
        {
            return (NetHandlerPlayServer) handler;
        }

        if (handler == null)
        {
            return null;
        }

        if (!(handler instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("Handler is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) handler).getForgeInstance();
    }

    public static IServerNetworkHandler fromForge(final NetHandlerPlayServer handler)
    {
        if (handler instanceof IServerNetworkHandler)
        {
            return (IServerNetworkHandler) handler;
        }

        return new ServerNetworkHandler(handler);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getHandler();
    }
}
