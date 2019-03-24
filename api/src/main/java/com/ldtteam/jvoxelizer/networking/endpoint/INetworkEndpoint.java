package com.ldtteam.jvoxelizer.networking.endpoint;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.networking.messaging.IMessage;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageContext;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPoint;
import com.ldtteam.jvoxelizer.threading.IExecutor;
import com.ldtteam.jvoxelizer.util.distribution.IDistribution;

public interface INetworkEndpoint
{

    static INetworkEndpoint create(String channelName)
    {
        return INetworkEndpointProviderHolder.getInstance().provide(channelName);
    }

    /**
     * Send this message to everyone.
     * The {@link IMessage} for this message type should be on the CLIENT side.
     *
     * @param message The message to send
     */
    void sendToAll(IMessage message);

    /**
     * Send this message to the specified player.
     * The {@link IMessage} for this message type should be on the CLIENT side.
     *
     * @param message The message to send
     * @param player The player to send it to
     */
    void sendTo(IMessage message, IMultiplayerPlayerEntity player);

    /**
     * Send this message to everyone within a certain range of a point.
     * The {@link IMessage} for this message type should be on the CLIENT side.
     *
     * @param message The message to send
     * @param point The {@link INetworkTargetPoint} around which to send
     */
    void sendToAllAround(IMessage message, INetworkTargetPoint point);

    /**
     * Send this message to everyone within the supplied dimension.
     * The {@link IMessage} for this message type should be on the CLIENT side.
     *
     * @param message The message to send
     * @param dimensionId The dimension id to target
     */
    void sendToDimension(IMessage message, int dimensionId);

    /**
     * Send this message to the server.
     * The {@link IMessage} for this message type should be on the SERVER side.
     *
     * @param message The message to send
     */
    void sendToServer(IMessage message);

    /**
     * Returns the {@link IExecutor} that is responsible for executing logical code on the side who's {@link IMessageContext} is given.
     *
     * @param context The {@link IMessageContext} generated when an {@link IMessage} is received.
     *
     * @return The {@link IExecutor} responsible for executing logical code.
     */
    IExecutor getExecutorFromContext(IMessageContext context);

}
