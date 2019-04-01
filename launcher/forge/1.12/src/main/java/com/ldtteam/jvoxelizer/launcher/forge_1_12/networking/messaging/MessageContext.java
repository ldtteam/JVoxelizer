package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.handler.ServerNetworkHandler;
import com.ldtteam.jvoxelizer.networking.handler.IServerNetworkHandler;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageContext;

public class MessageContext implements IMessageContext, IForgeJVoxelizerWrapper
{
    private net.minecraftforge.fml.common.network.simpleimpl.MessageContext context;

    private MessageContext(final net.minecraftforge.fml.common.network.simpleimpl.MessageContext context)
    {
        this.context = context;
    }

    @Override
    public IServerNetworkHandler getServerHandler()
    {
        return ServerNetworkHandler.fromForge(context.getServerHandler());
    }

    private net.minecraftforge.fml.common.network.simpleimpl.MessageContext getContext()
    {
        return context;
    }

    public static net.minecraftforge.fml.common.network.simpleimpl.MessageContext asForge(final IMessageContext messageContext)
    {
        if (messageContext instanceof net.minecraftforge.fml.common.network.simpleimpl.MessageContext)
        {
            return (net.minecraftforge.fml.common.network.simpleimpl.MessageContext) messageContext;
        }

        if (messageContext == null)
        {
            return null;
        }

        if (!(messageContext instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("MessageContext is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) messageContext).getForgeInstance();
    }

    public static IMessageContext fromForge(final net.minecraftforge.fml.common.network.simpleimpl.MessageContext tuple)
    {
        if (tuple instanceof IMessageContext)
        {
            return (IMessageContext) tuple;
        }

        return new MessageContext(tuple);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getContext();
    }
}
