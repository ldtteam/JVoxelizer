package com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.endpoint;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.entity.living.player.MultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging.JVoxMessageWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging.JVoxMessageWrapperHandler;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.messaging.MessageContext;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.networking.utils.target.NetworkTargetPoint;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.threading.Executor;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.distribution.executor.DistributionExecutor;
import com.ldtteam.jvoxelizer.networking.endpoint.INetworkEndpoint;
import com.ldtteam.jvoxelizer.networking.messaging.IMessage;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageContext;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPoint;
import com.ldtteam.jvoxelizer.threading.IExecutor;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import java.util.function.Supplier;

public class NetworkEndpoint implements INetworkEndpoint, IForgeJVoxelizerWrapper
{
    private SimpleNetworkWrapper manager;

    private NetworkEndpoint(final SimpleNetworkWrapper manager)
    {
        this.manager = manager;
        this.manager.registerMessage(JVoxMessageWrapperHandler.class, JVoxMessageWrapper.class, 0, Side.CLIENT);
        this.manager.registerMessage(JVoxMessageWrapperHandler.class, JVoxMessageWrapper.class, 1, Side.SERVER);
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
        final Supplier<IThreadListener> threadListenerSuplier = DistributionExecutor.getInstance().runOn(
          () -> new Supplier<IThreadListener>()
          {
              /**
               * Gets a result.
               *
               * @return a result
               */
              @Override
              public IThreadListener get()
              {
                  return Minecraft.getMinecraft();
              }
          },
          () -> new Supplier<IThreadListener>()
          {
              /**
               * Gets a result.
               *
               * @return a result
               */
              @Override
              public IThreadListener get()
              {
                  return FMLCommonHandler.instance().getMinecraftServerInstance();
              }
          }
        );

        final IThreadListener threadListener = threadListenerSuplier.get();

        return Executor.fromForge(threadListener);
    }

    private SimpleNetworkWrapper getManager()
    {
        return manager;
    }

    public static SimpleNetworkWrapper asForge(final INetworkEndpoint endpoint)
    {
        if (endpoint instanceof SimpleNetworkWrapper)
        {
            return (SimpleNetworkWrapper) endpoint;
        }

        if (endpoint == null)
        {
            return null;
        }

        if (!(endpoint instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("Endpoint is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) endpoint).getForgeInstance();
    }

    public static INetworkEndpoint fromForge(final SimpleNetworkWrapper networkWrapper)
    {
        if (networkWrapper instanceof INetworkEndpoint)
        {
            return (INetworkEndpoint) networkWrapper;
        }

        return new NetworkEndpoint(networkWrapper);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getManager();
    }
}
