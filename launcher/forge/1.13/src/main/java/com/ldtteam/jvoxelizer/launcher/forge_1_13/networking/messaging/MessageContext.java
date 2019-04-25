package com.ldtteam.jvoxelizer.launcher.forge_1_13.networking.messaging;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player.MultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.networking.handler.ServerNetworkHandler;
import com.ldtteam.jvoxelizer.networking.handler.IServerNetworkHandler;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageContext;
import net.minecraftforge.fml.network.NetworkEvent;

public class MessageContext implements IMessageContext, IForgeJVoxelizerWrapper
{
    private NetworkEvent.Context context;

    private MessageContext(final NetworkEvent.Context context)
    {
        this.context = context;
    }

    private NetworkEvent.Context getContext()
    {
        return context;
    }

    public static NetworkEvent.Context asForge(final IMessageContext messageContext)
    {
        if (messageContext instanceof NetworkEvent.Context)
        {
            return (NetworkEvent.Context) messageContext;
        }

        if (messageContext == null)
        {
            return null;
        }

        if (!(messageContext instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("MessageContext is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) messageContext).getForgeInstance();
    }

    public static IMessageContext fromForge(final NetworkEvent.Context tuple)
    {
        if (tuple instanceof IMessageContext)
        {
            return (IMessageContext) tuple;
        }

        return new MessageContext(tuple);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getContext();
    }

    @Override
    public IMultiplayerPlayerEntity getSendingPlayer()
    {
        return MultiplayerPlayerEntity.fromForge(context.getSender());
    }
}
