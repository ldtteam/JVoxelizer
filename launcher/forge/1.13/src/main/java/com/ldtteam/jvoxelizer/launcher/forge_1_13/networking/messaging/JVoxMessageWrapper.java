package com.ldtteam.jvoxelizer.launcher.forge_1_13.networking.messaging;

import net.minecraft.network.PacketBuffer;

public class JVoxMessageWrapper
{
    private com.ldtteam.jvoxelizer.networking.messaging.IMessage jvoxMessage;

    public JVoxMessageWrapper(final com.ldtteam.jvoxelizer.networking.messaging.IMessage jvoxMessage) {this.jvoxMessage = jvoxMessage;}

    public JVoxMessageWrapper(PacketBuffer buf)
    {
        this.fromBytes(buf);
    }

    /**
     * Convert from the supplied buffer into your specific message type
     */
    public void fromBytes(final PacketBuffer buf)
    {
        final String className = buf.readString(Integer.MAX_VALUE);
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
    public void toBytes(final PacketBuffer buf)
    {
        buf.writeString(getJvoxMessage().getClass().getName());
        getJvoxMessage().toBytes(buf);
    }

    com.ldtteam.jvoxelizer.networking.messaging.IMessage getJvoxMessage()
    {
        return jvoxMessage;
    }
}
