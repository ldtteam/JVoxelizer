package com.ldtteam.jvoxelizer.launcher.forge_1_13.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.common.gameevent.event.player.IPlayerEntityEvent;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.event.Event;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.inventory.Container;

public class PlayerEntityEvent extends Event implements IPlayerEntityEvent
{

    private final net.minecraftforge.event.entity.player.PlayerEvent forgePlayerEvent;

    protected PlayerEntityEvent(final net.minecraftforge.event.entity.player.PlayerEvent forgePlayerEvent) {
        super(forgePlayerEvent);
        this.forgePlayerEvent = forgePlayerEvent;
    }

    private net.minecraftforge.event.entity.player.PlayerEvent getForgePlayerEvent()
    {
        return forgePlayerEvent;
    }

    @Override
    public IPlayerEntity getPlayer()
    {
        return PlayerEntity.fromForge(forgePlayerEvent.getEntityPlayer());
    }

    public static IPlayerEntityEvent fromForge(net.minecraftforge.event.entity.player.PlayerEvent playerEvent)
    {
        if (playerEvent instanceof IPlayerEntityEvent)
            return (IPlayerEntityEvent) playerEvent;

        if (playerEvent == null)
            return null;

        return new PlayerEntityEvent(playerEvent);
    }

    public static net.minecraftforge.event.entity.player.PlayerEvent asForge(IPlayerEntityEvent playerEvent)
    {
        if (playerEvent instanceof net.minecraftforge.event.entity.player.PlayerEvent)
            return (net.minecraftforge.event.entity.player.PlayerEvent) playerEvent;

        if (playerEvent == null)
            return null;

        if (!(playerEvent instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("PlayerEvent is not a wrapper");

        return ((IForgeJVoxelizerWrapper) playerEvent).getForgeInstance();
    }

    public static class ContainerEvent extends PlayerEntityEvent implements IContainerEvent
    {

        private final IContainer<?> container;

        protected ContainerEvent(net.minecraftforge.event.entity.player.PlayerContainerEvent playerContainerEvent)
        {
            super(playerContainerEvent);
            this.container = Container.fromForge(playerContainerEvent.getContainer());
        }

        @Override
        public IContainer<?> getContainer()
        {
            return container;
        }

        public static IContainerEvent fromForge(net.minecraftforge.event.entity.player.PlayerContainerEvent playerContainerEvent)
        {
            if (playerContainerEvent instanceof IContainerEvent)
                return (IContainerEvent) playerContainerEvent;

            if (playerContainerEvent == null)
                return null;

            return new ContainerEvent(playerContainerEvent);
        }

        public static net.minecraftforge.event.entity.player.PlayerContainerEvent asForge(IContainerEvent playerContainerEvent)
        {
            if (playerContainerEvent instanceof net.minecraftforge.event.entity.player.PlayerContainerEvent)
                return (net.minecraftforge.event.entity.player.PlayerContainerEvent) playerContainerEvent;

            if (playerContainerEvent == null)
                return null;

            if (!(playerContainerEvent instanceof IForgeJVoxelizerWrapper))
                throw new IllegalArgumentException("PlayerContainerEvent is not a wrapper");

            return ((IForgeJVoxelizerWrapper) playerContainerEvent).getForgeInstance();
        }

        public static class Open extends ContainerEvent implements IOpen
        {

            private Open(final net.minecraftforge.event.entity.player.PlayerContainerEvent.Open playerContainerEventOpen)
            {
                super(playerContainerEventOpen);
            }

            public static IOpen fromForge(net.minecraftforge.event.entity.player.PlayerContainerEvent.Open playerContainerEventOpen)
            {
                if (playerContainerEventOpen instanceof IOpen)
                    return (IOpen) playerContainerEventOpen;

                if (playerContainerEventOpen == null)
                    return null;

                return new Open(playerContainerEventOpen);
            }

            public static net.minecraftforge.event.entity.player.PlayerContainerEvent.Open asForge(IOpen open)
            {
                if (open instanceof net.minecraftforge.event.entity.player.PlayerContainerEvent.Open)
                    return (net.minecraftforge.event.entity.player.PlayerContainerEvent.Open) open;

                if (open == null)
                    return null;

                if (!(open instanceof IForgeJVoxelizerWrapper))
                    throw new IllegalArgumentException("Open is not a wrapper");

                return ((IForgeJVoxelizerWrapper) open).getForgeInstance();
            }
        }

        public static class Close extends ContainerEvent implements IClose
        {

            private Close(final net.minecraftforge.event.entity.player.PlayerContainerEvent.Close playerContainerEventClose)
            {
                super(playerContainerEventClose);
            }

            public static IClose fromForge(net.minecraftforge.event.entity.player.PlayerContainerEvent.Close playerContainerEventClose)
            {
                if (playerContainerEventClose instanceof IClose)
                    return (IClose) playerContainerEventClose;

                if (playerContainerEventClose == null)
                    return null;

                return new Close(playerContainerEventClose);
            }

            public static net.minecraftforge.event.entity.player.PlayerContainerEvent.Close asForge(IClose close)
            {
                if (close instanceof net.minecraftforge.event.entity.player.PlayerContainerEvent.Close)
                    return (net.minecraftforge.event.entity.player.PlayerContainerEvent.Close) close;

                if (close == null)
                    return null;

                if (!(close instanceof IForgeJVoxelizerWrapper))
                    throw new IllegalArgumentException("Close is not a wrapper");

                return ((IForgeJVoxelizerWrapper) close).getForgeInstance();
            }
        }
    }
}
