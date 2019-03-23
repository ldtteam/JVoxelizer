package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging;

import com.ldtteam.jvoxelizer.networking.messaging.IMessage;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageContext;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageHandler;

public class MessageHandler implements IMessageHandler
{
    private net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler<net.minecraftforge.fml.common.network.simpleimpl.IMessage, net.minecraftforge.fml.common.network.simpleimpl.IMessage> handler;

    private MessageHandler(final net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler<net.minecraftforge.fml.common.network.simpleimpl.IMessage, net.minecraftforge.fml.common.network.simpleimpl.IMessage> handler)
    {
        this.handler = handler;
    }

    @Override
    public IMessage onMessage(final IMessage message, final IMessageContext ctx)
    {
        return Message.fromForge(this.handler.onMessage(Message.asForge(message), MessageContext.asForge(ctx)));
    }

    public static net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler<net.minecraftforge.fml.common.network.simpleimpl.IMessage, net.minecraftforge.fml.common.network.simpleimpl.IMessage> asForge(final IMessageHandler handler)
    {
        if (handler instanceof net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler)
            return (net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler<net.minecraftforge.fml.common.network.simpleimpl.IMessage, net.minecraftforge.fml.common.network.simpleimpl.IMessage>) handler;

        return ((MessageHandler) handler).handler;
    }

    public static IMessageHandler fromForge(final net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler<net.minecraftforge.fml.common.network.simpleimpl.IMessage, net.minecraftforge.fml.common.network.simpleimpl.IMessage> handler)
    {
        if (handler instanceof IMessageHandler)
            return (IMessageHandler) handler;

        return new MessageHandler(handler);
    }
}
