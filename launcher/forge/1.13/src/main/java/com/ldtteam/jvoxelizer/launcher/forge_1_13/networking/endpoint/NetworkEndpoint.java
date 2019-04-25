package com.ldtteam.jvoxelizer.launcher.forge_1_13.networking.endpoint;

import com.ldtteam.jvoxelizer.entity.living.player.IMultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player.MultiplayerPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.networking.messaging.JVoxMessageWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.networking.messaging.JVoxMessageWrapperHandler;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.networking.utils.target.NetworkTargetPoint;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.threading.Executor;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.distribution.executor.DistributionExecutor;
import com.ldtteam.jvoxelizer.networking.endpoint.INetworkEndpoint;
import com.ldtteam.jvoxelizer.networking.messaging.IMessage;
import com.ldtteam.jvoxelizer.networking.messaging.IMessageContext;
import com.ldtteam.jvoxelizer.networking.utils.target.INetworkTargetPoint;
import com.ldtteam.jvoxelizer.threading.IExecutor;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import java.util.function.Supplier;

public class NetworkEndpoint implements INetworkEndpoint, IForgeJVoxelizerWrapper
{
    private SimpleChannel manager;

    private NetworkEndpoint(final SimpleChannel manager)
    {
        this.manager = manager;

        this.manager.registerMessage(
          0,
          JVoxMessageWrapper.class,
          JVoxMessageWrapper::toBytes,
          JVoxMessageWrapper::new,
          (message, contextSupplier) -> {
              final NetworkEvent.Context context = contextSupplier.get();
              final JVoxMessageWrapperHandler handler = new JVoxMessageWrapperHandler();

              handler.onMessage(message, context);

          }
        );


    }

    @Override
    public void sendToAll(final IMessage message)
    {
        manager.send(PacketDistributor.ALL.noArg(), new JVoxMessageWrapper(message));
    }

    @Override
    public void sendTo(final IMessage message, final IMultiplayerPlayerEntity player)
    {
        manager.send(PacketDistributor.PLAYER.with(() -> MultiplayerPlayerEntity.asForge(player)), new JVoxMessageWrapper(message));
    }

    @Override
    public void sendToAllAround(final IMessage message, final INetworkTargetPoint point)
    {
        manager.send(PacketDistributor.NEAR.with(() -> NetworkTargetPoint.asForge(point)), message);
    }

    @Override
    public void sendToDimension(final IMessage message, final int dimensionId)
    {
        manager.send(PacketDistributor.DIMENSION.with(() -> DimensionType.getById(dimensionId)), message);
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
                  return Minecraft.getInstance();
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
                  return ServerLifecycleHooks.getCurrentServer();
              }
          }
        );

        final IThreadListener threadListener = threadListenerSuplier.get();

        return Executor.fromForge(threadListener);
    }

    private SimpleChannel getManager()
    {
        return manager;
    }

    public static SimpleChannel asForge(final INetworkEndpoint endpoint)
    {
        if (endpoint instanceof SimpleChannel)
        {
            return (SimpleChannel) endpoint;
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

    public static INetworkEndpoint fromForge(final SimpleChannel networkWrapper)
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
