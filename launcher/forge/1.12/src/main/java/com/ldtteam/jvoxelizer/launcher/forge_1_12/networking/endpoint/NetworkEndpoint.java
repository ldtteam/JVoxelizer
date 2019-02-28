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

    public NetworkEndpoint(final SimpleNetworkWrapper manager)
    {
        this.manager = manager;
    }

    @Override
    public <REQ extends IMessage, REPLY extends IMessage> void registerMessage(final Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, final Class<REQ> requestMessageType, final int discriminator, final IDistribution distribution)
    {
        manager.registerMessage(((MessageHandler) messageHandler).getForgeHandler().getClass(), requestMessageType, discriminator, ((Distribution) distribution).getForgeSide());
    }

    @Override
    public <REQ extends IMessage, REPLY extends IMessage> void registerMessage(
      final IMessageHandler<? super REQ, ? extends REPLY> messageHandler, final Class<REQ> requestMessageType, final int discriminator, final IDistribution distribution)
    {
        manager.registerMessage(((MessageHandler) messageHandler).getForgeHandler(), requestMessageType, discriminator, ((Distribution) distribution).getForgeSide());
    }

    @Override
    public void sendToAll(final IMessage message)
    {
        manager.sendToAll(((Message) message).getForgeMessage());
    }

    @Override
    public void sendTo(final IMessage message, final IMultiplayerPlayerEntity player)
    {
        manager.sendTo(((Message) message).getForgeMessage(), ((MultiplayerPlayerEntity) player).getForgePlayer());
    }

    @Override
    public void sendToAllAround(final IMessage message, final INetworkTargetPoint point)
    {
        manager.sendToAllAround(((Message) message).getForgeMessage(), ((NetworkTargetPoint) point).getForgeTargetPoint());
    }

    @Override
    public void sendToDimension(final IMessage message, final int dimensionId)
    {
        manager.sendToDimension(((Message) message).getForgeMessage(), dimensionId);
    }

    @Override
    public void sendToServer(final IMessage message)
    {
        manager.sendToServer(((Message) message).getForgeMessage());
    }

    @Override
    public IExecutor getExecutorFromContext(final IMessageContext context)
    {
        //todo orion?
    }
}
