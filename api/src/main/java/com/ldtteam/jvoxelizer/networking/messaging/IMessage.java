package com.ldtteam.jvoxelizer.networking.messaging;

import io.netty.buffer.ByteBuf;

/**
 * Describes a message between the client and the server.
 * This interface is derived of the Minecraft SimpleNetworkWrapper added by forge and created by CPW.
 */
public interface IMessage {
    /**
     * Convert from the supplied buffer into your specific message type
     *
     * @param buf The buffer to read the message data from.
     */
    void fromBytes(ByteBuf buf);

    /**
     * Deconstruct your message into the supplied byte buffer.
     *
     * @param buf The buffer to write your message data into.
     */
    void toBytes(ByteBuf buf);

    /**
     * Called by the messaging system to indicate that this message arrived at target side.
     * @param ctx The message context.
     * @return A reply if need be. Null if no reply is required.
     */
    IMessage onArrived(IMessageContext ctx);
}
