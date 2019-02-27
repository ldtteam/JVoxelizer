package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging;

import com.ldtteam.jvoxelizer.networking.messaging.IMessage;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageContext;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageHandler;

public class MessageHandler implements IMessageHandler
{
    private net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler handler;

    public MessageHandler(final net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler handler)
    {
        this.handler = handler;
    }

    @Override
    public IMessage onMessage(final IMessage message, final IMessageContext ctx)
    {
        return new Message(this.handler.onMessage(((Message) message).getForgeMessage(), ((MessageContext) ctx).getForgeContext()));
    }
}
