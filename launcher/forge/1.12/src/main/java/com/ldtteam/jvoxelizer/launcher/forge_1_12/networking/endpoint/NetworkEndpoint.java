package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.endpoint;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.MultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging.JVoxMessageWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging.MessageContext;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.utils.target.NetworkTargetPoint;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.threading.Executor;
import com.ldtteam.jvoxelizer.networking.endpoint.INetworkEndpoint;
import com.ldtteam.jvoxelizer.networking.messaging.IMessage;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageContext;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPoint;
import com.ldtteam.jvoxelizer.threading.IExecutor;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkEndpoint implements INetworkEndpoint
{
    private SimpleNetworkWrapper manager;

    private NetworkEndpoint(final SimpleNetworkWrapper manager)
    {
        this.manager = manager;
        this.manager.registerMessage(JVoxMessageWrapper.class, JVoxMessageWrapper.class, 0, Side.CLIENT);
        this.manager.registerMessage(JVoxMessageWrapper.class, JVoxMessageWrapper.class, 1, Side.SERVER);
    }

    @Override
    public void sendToAll(final IMessage message)
    {
        manager.sendToAll(new JVoxMessageWrapper(message));
    }

    @Override
    public void sendTo(final IMessage message, final IMultiplayerPlayerEntity player)
    {
        manager.sendTo(new JVoxMessageWrapper(message), MultiplayerPlayerEntity.asForge(player));
    }

    @Override
    public void sendToAllAround(final IMessage message, final INetworkTargetPoint point)
    {
        manager.sendToAllAround(new JVoxMessageWrapper(message), NetworkTargetPoint.asForge(point));
    }

    @Override
    public void sendToDimension(final IMessage message, final int dimensionId)
    {
        manager.sendToDimension(new JVoxMessageWrapper(message), dimensionId);
    }

    @Override
    public void sendToServer(final IMessage message)
    {
        manager.sendToServer(new JVoxMessageWrapper(message));
    }

    @Override
    public IExecutor getExecutorFromContext(final IMessageContext context)
    {
        return Executor.fromForge(FMLCommonHandler.instance().getWorldThread(MessageContext.asForge(context).netHandler));
    }

    public static SimpleNetworkWrapper asForge(final INetworkEndpoint endpoint)
    {
        if (endpoint instanceof SimpleNetworkWrapper)
            return (SimpleNetworkWrapper) endpoint;

        return ((NetworkEndpoint) endpoint).manager;
    }

    public static INetworkEndpoint fromForge(final SimpleNetworkWrapper networkWrapper)
    {
        if (networkWrapper instanceof INetworkEndpoint)
            return (INetworkEndpoint) networkWrapper;

        return new NetworkEndpoint(networkWrapper);
    }
}
