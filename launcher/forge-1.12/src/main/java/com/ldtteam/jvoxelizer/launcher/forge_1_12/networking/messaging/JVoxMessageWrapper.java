package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class JVoxMessageWrapper implements IMessage
{
    private com.ldtteam.jvoxelizer.networking.messaging.IMessage jvoxMessage;

    public JVoxMessageWrapper(final com.ldtteam.jvoxelizer.networking.messaging.IMessage jvoxMessage) {this.jvoxMessage = jvoxMessage;}

    public JVoxMessageWrapper()
    {
    }

    /**
     * Convert from the supplied buffer into your specific message type
     */
    @Override
    public void fromBytes(final ByteBuf buf)
    {
        final String className = ByteBufUtils.readUTF8String(buf);
        try
        {
            jvoxMessage = (com.ldtteam.jvoxelizer.networking.messaging.IMessage) Class.forName(className).newInstance();
            jvoxMessage.fromBytes(buf);
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Could read message.", e);
        }
    }

    /**
     * Deconstruct your message into the supplied byte buffer
     */
    @Override
    public void toBytes(final ByteBuf buf)
    {
        ByteBufUtils.writeUTF8String(buf, jvoxMessage.getClass().getName());
        jvoxMessage.toBytes(buf);
    }

    com.ldtteam.jvoxelizer.networking.messaging.IMessage getJvoxMessage()
    {
        return jvoxMessage;
    }
}
