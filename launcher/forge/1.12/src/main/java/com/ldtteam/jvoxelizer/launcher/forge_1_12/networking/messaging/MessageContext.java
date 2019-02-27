package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.handler.ServerNetworkHandler;
import com.ldtteam.jvoxelizer.networking.handler.IServerNetworkHandler;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageContext;

public class MessageContext implements IMessageContext
{
    private net.minecraftforge.fml.common.network.simpleimpl.MessageContext context;

    public MessageContext(final net.minecraftforge.fml.common.network.simpleimpl.MessageContext context)
    {
        this.context = context;
    }

    @Override
    public IServerNetworkHandler getServerHandler()
    {
        return new ServerNetworkHandler(context.getServerHandler());
    }

    /**
     * Getter to get the wrapped forge element.
     * @return the forge MessageContext.
     */
    public net.minecraftforge.fml.common.network.simpleimpl.MessageContext getForgeContext()
    {
        return context;
    }
}
