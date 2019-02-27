package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging;

import com.ldtteam.jvoxelizer.networking.messaging.IMessage;
import io.netty.buffer.ByteBuf;

public class Message implements IMessage
{
    private net.minecraftforge.fml.common.network.simpleimpl.IMessage message;

    public Message(final net.minecraftforge.fml.common.network.simpleimpl.IMessage message)
    {
        this.message = message;
    }

    @Override
    public void fromBytes(final ByteBuf buf)
    {
        message.fromBytes(buf);
    }

    @Override
    public void toBytes(final ByteBuf buf)
    {
        message.toBytes(buf);
    }

    /**
     * Get the wrapped forge message.
     * @return the IMessage.
     */
    public net.minecraftforge.fml.common.network.simpleimpl.IMessage getForgeMessage()
    {
        return this.message;
    }
}
