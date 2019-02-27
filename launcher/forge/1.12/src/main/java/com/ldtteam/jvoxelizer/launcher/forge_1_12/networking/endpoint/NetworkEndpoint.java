package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.endpoint;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.networking.endpoint.INetworkEndpoint;
import com.ldtteam.jvoxelizer.networking.messaging.IMessage;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageContext;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageHandler;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPoint;
import com.ldtteam.jvoxelizer.threading.IExecutor;
import com.ldtteam.jvoxelizer.util.distribution.IDistribution;

/**
 * TODO Orion?
 */
public class NetworkEndpoint implements INetworkEndpoint
{
    @Override
    public <REQ extends IMessage, REPLY extends IMessage> void registerMessage(final Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, final Class<REQ> requestMessageType, final int discriminator, final IDistribution distribution)
    {

    }

    @Override
    public <REQ extends IMessage, REPLY extends IMessage> void registerMessage(
      final IMessageHandler<? super REQ, ? extends REPLY> messageHandler, final Class<REQ> requestMessageType, final int discriminator, final IDistribution distribution)
    {

    }

    @Override
    public void sendToAll(final IMessage message)
    {

    }

    @Override
    public void sendTo(final IMessage message, final IMultiplayerPlayerEntity player)
    {

    }

    @Override
    public void sendToAllAround(final IMessage message, final INetworkTargetPoint point)
    {

    }

    @Override
    public void sendToDimension(final IMessage message, final int dimensionId)
    {

    }

    @Override
    public void sendToServer(final IMessage message)
    {

    }

    @Override
    public IExecutor getExecutorFromContext(final IMessageContext context)
    {
        return null;
    }
}
