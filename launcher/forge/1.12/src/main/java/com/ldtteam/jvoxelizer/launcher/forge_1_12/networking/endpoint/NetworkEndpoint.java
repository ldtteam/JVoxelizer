package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.endpoint;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.MultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging.Message;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging.MessageHandler;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.utils.target.NetworkTargetPoint;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.distribution.Distribution;
import com.ldtteam.jvoxelizer.networking.endpoint.INetworkEndpoint;
import com.ldtteam.jvoxelizer.networking.messaging.IMessage;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageContext;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageHandler;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPoint;
import com.ldtteam.jvoxelizer.threading.IExecutor;
import com.ldtteam.jvoxelizer.util.distribution.IDistribution;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class NetworkEndpoint implements INetworkEndpoint
{
    private SimpleNetworkWrapper manager;

    private NetworkEndpoint(final SimpleNetworkWrapper manager)
    {
        this.manager = manager;
    }

    @Override
    public <REQ extends IMessage, REPLY extends IMessage> void registerMessage(final Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, final Class<REQ> requestMessageType, final int discriminator, final IDistribution distribution)
    {
        //todo Orion
        manager.registerMessage(MessageHandler.asForge(messageHandler).getClass(), requestMessageType, discriminator, Distribution.asForge(distribution));
    }

    @Override
    public <REQ extends IMessage, REPLY extends IMessage> void registerMessage(final IMessageHandler<? super REQ, ? extends REPLY> messageHandler, final Class<REQ> requestMessageType, final int discriminator, final IDistribution distribution)
    {
        //todo Orion
        manager.registerMessage(MessageHandler.asForge(messageHandler), requestMessageType, discriminator, Distribution.asForge(distribution));
    }

    @Override
    public void sendToAll(final IMessage message)
    {
        manager.sendToAll(Message.asForge(message));
    }

    @Override
    public void sendTo(final IMessage message, final IMultiplayerPlayerEntity player)
    {
        manager.sendTo(Message.asForge(message), MultiplayerPlayerEntity.asForge(player));
    }

    @Override
    public void sendToAllAround(final IMessage message, final INetworkTargetPoint point)
    {
        manager.sendToAllAround(Message.asForge(message), ((NetworkTargetPoint) point).getForgeTargetPoint());
    }

    @Override
    public void sendToDimension(final IMessage message, final int dimensionId)
    {
        manager.sendToDimension(Message.asForge(message), dimensionId);
    }

    @Override
    public void sendToServer(final IMessage message)
    {
        manager.sendToServer(Message.asForge(message));
    }

    @Override
    public IExecutor getExecutorFromContext(final IMessageContext context)
    {
        //todo orion?
    }

    public static SimpleNetworkWrapper asForge(final INetworkEndpoint endpoint)
    {
        if (endpoint instanceof SimpleNetworkWrapper)
            return (SimpleNetworkWrapper) endpoint;

        return ((NetworkEndpoint) endpoint).manager;
    }

    public static INetworkEndpoint fromForge(final SimpleNetworkWrapper networkWrapper)
    {
        if (networkWrapper instanceof INetworkEndpoint)
            return (INetworkEndpoint) networkWrapper;

        return new NetworkEndpoint(networkWrapper);
    }
}
