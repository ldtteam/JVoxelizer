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
}
