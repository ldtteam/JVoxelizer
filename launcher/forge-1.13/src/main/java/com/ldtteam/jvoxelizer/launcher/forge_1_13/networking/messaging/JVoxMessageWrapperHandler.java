package com.ldtteam.jvoxelizer.launcher.forge_1_13.networking.messaging;

import net.minecraftforge.fml.network.NetworkEvent;

public class JVoxMessageWrapperHandler
{
    /**
     * Called when a message is received of the appropriate type. You can optionally return a reply message, or null if no reply
     * is needed.
     *
     * @param message The message
     */
    public void onMessage(final JVoxMessageWrapper message, final NetworkEvent.Context ctx)
    {
        message.getJvoxMessage().onArrived(MessageContext.fromForge(ctx));
    }
}
