package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging;

import com.ldtteam.jvoxelizer.networking.messaging.IMessage;
import io.netty.buffer.ByteBuf;

public class Message implements IMessage
{
    private net.minecraftforge.fml.common.network.simpleimpl.IMessage message;

    private Message(final net.minecraftforge.fml.common.network.simpleimpl.IMessage message)
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

    public static net.minecraftforge.fml.common.network.simpleimpl.IMessage asForge(final IMessage tuple)
    {
        if (tuple instanceof net.minecraftforge.fml.common.network.simpleimpl.IMessage)
            return (net.minecraftforge.fml.common.network.simpleimpl.IMessage) tuple;

        return ((Message) tuple).message;
    }

    public static IMessage fromForge(final net.minecraftforge.fml.common.network.simpleimpl.IMessage tuple)
    {
        if (tuple instanceof IMessage)
            return (IMessage) tuple;

        return new Message(tuple);
    }
}
