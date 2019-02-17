package com.ldtteam.jvoxelizer.networking.messaging;

import com.ldtteam.jvoxelizer.networking.endpoint.INetworkEndpoint;
import com.ldtteam.jvoxelizer.util.distribution.IDistribution;

/**
 * A message handler based on {@link IMessage}.
 * Implement and override {@link #onMessage(IMessage, IMessageContext)} to process your packet.
 * Supply the class to {@link INetworkEndpoint#registerMessage(IMessageHandler, Class, int, IDistribution)}
 * to register both the message type and it's associated handler.
 *
 * This message handler follows the message handler api surface defined in the Minecraft SimpleNetworkWrapper implementation in forge made by cpw.
 *
 * @param <I> This is the request type - it is the message you expect to <em>receive</em> from remote.
 * @param <O> This is the reply type - it is the message you expect to <em>send</em> in reply. You can use IMessage as the type here
 * if you don't anticipate sending a reply.
 */
public interface IMessageHandler<I extends IMessage, O extends IMessage> {
    /**
     * Called when a message is received of the appropriate type. You can optionally return a reply message, or null if no reply
     * is needed.
     *
     * @param message The message
     * @return an optional return message
     */
    O onMessage(I message, IMessageContext ctx);
}
