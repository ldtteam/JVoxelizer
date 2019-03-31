package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class JVoxMessageWrapperHandler implements IMessageHandler<JVoxMessageWrapper, IMessage>
{
    /**
     * Called when a message is received of the appropriate type. You can optionally return a reply message, or null if no reply
     * is needed.
     *
     * @param message The message
     * @return an optional return message
     */
    @Override
    public IMessage onMessage(final JVoxMessageWrapper message, final MessageContext ctx)
    {
        final com.ldtteam.jvoxelizer.networking.messaging.IMessage message1 = message.getJvoxMessage().onArrived(com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging.MessageContext.fromForge(ctx));
        if (message1 != null)
            return new JVoxMessageWrapper(message1);

        return null;
    }
}
