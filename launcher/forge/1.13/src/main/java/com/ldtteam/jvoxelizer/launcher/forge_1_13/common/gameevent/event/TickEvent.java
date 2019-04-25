package com.ldtteam.jvoxelizer.launcher.forge_1_13.common.gameevent.event;

import com.ldtteam.jvoxelizer.common.gameevent.event.ITickEvent;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.entity.living.player.PlayerEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.event.Event;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.distribution.Distribution;
import com.ldtteam.jvoxelizer.util.distribution.IDistribution;

public class TickEvent extends Event implements ITickEvent
{

    private final net.minecraftforge.fml.common.gameevent.TickEvent forgeTickEvent;

    protected TickEvent(final net.minecraftforge.fml.common.gameevent.TickEvent forgeTickEvent) {
        super(forgeTickEvent);
        this.forgeTickEvent = forgeTickEvent;
    }

    /**
     * The {@link IDistribution} under which this {@link ITickEvent} was fired.
     *
     * @return The {@link IDistribution}.
     */
    @Override
    public IDistribution getDistribution()
    {
        return Distribution.fromForge(forgeTickEvent.side);
    }

    /**
     * The {@link Phase} for which this {@link ITickEvent} was fired.
     *
     * @return The {@link Phase}.
     */
    @Override
    public Phase getPhase()
    {
        return forgeTickEvent.phase == net.minecraftforge.fml.common.gameevent.TickEvent.Phase.START ? Phase.START : Phase.END;
    }

    public static ITickEvent fromForge(net.minecraftforge.fml.common.gameevent.TickEvent tickEvent)
    {
        if (tickEvent instanceof ITickEvent)
            return (ITickEvent) tickEvent;

        if (tickEvent == null)
            return null;

        return new TickEvent(tickEvent);
    }

    public static net.minecraftforge.fml.common.gameevent.TickEvent asForge(ITickEvent event)
    {
        if (event instanceof net.minecraftforge.fml.common.gameevent.TickEvent)
            return (net.minecraftforge.fml.common.gameevent.TickEvent) event;

        if (event == null)
            return null;

        if (!(event instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("TickEvent is not a wrapper.");

        return ((IForgeJVoxelizerWrapper) event).getForgeInstance();
    }
    
    public static class Server extends TickEvent implements IServerTickEvent
    {

        private Server(final net.minecraftforge.fml.common.gameevent.TickEvent forgeTickEvent)
        {
            super(forgeTickEvent);
        }

        public static IServerTickEvent fromForge(net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent tickEvent)
        {
            if (tickEvent instanceof ITickEvent)
                return (IServerTickEvent) tickEvent;

            if (tickEvent == null)
                return null;

            return new Server(tickEvent);
        }

        public static net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent asForge(IServerTickEvent event)
        {
            if (event instanceof net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent)
                return (net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent) event;

            if (event == null)
                return null;

            if (!(event instanceof IForgeJVoxelizerWrapper))
                throw new IllegalArgumentException("ServerTickEvent is not a wrapper.");

            return ((IForgeJVoxelizerWrapper) event).getForgeInstance();
        }
    }

    public static class Client extends TickEvent implements IClientTickEvent
    {

        private Client(final net.minecraftforge.fml.common.gameevent.TickEvent forgeTickEvent)
        {
            super(forgeTickEvent);
        }

        public static IClientTickEvent fromForge(net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent tickEvent)
        {
            if (tickEvent instanceof ITickEvent)
                return (IClientTickEvent) tickEvent;

            if (tickEvent == null)
                return null;

            return new Client(tickEvent);
        }

        public static net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent asForge(IClientTickEvent event)
        {
            if (event instanceof net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent)
                return (net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent) event;

            if (event == null)
                return null;

            if (!(event instanceof IForgeJVoxelizerWrapper))
                throw new IllegalArgumentException("ClientTickEvent is not a wrapper.");

            return ((IForgeJVoxelizerWrapper) event).getForgeInstance();
        }
    }

    public static class Dimension extends TickEvent implements IDimensionTickEvent
    {
        private final net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent worldTickEvent;

        private Dimension(final net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent forgeTickEvent)
        {
            super(forgeTickEvent);
            worldTickEvent = forgeTickEvent;
        }

        public static IDimensionTickEvent fromForge(net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent tickEvent)
        {
            if (tickEvent instanceof ITickEvent)
                return (IDimensionTickEvent) tickEvent;

            if (tickEvent == null)
                return null;

            return new Dimension(tickEvent);
        }

        public static net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent asForge(IDimensionTickEvent event)
        {
            if (event instanceof net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent)
                return (net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent) event;

            if (event == null)
                return null;

            if (!(event instanceof IForgeJVoxelizerWrapper))
                throw new IllegalArgumentException("DimensionTickEvent is not a wrapper.");

            return ((IForgeJVoxelizerWrapper) event).getForgeInstance();
        }

        /**
         * The {@link IDimension} that is being ticked.
         *
         * @return The {@link IDimension}.
         */
        @Override
        public IDimension getDimension()
        {
            return com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension.Dimension.fromForge(worldTickEvent.world);
        }
    }

    public static class Player extends TickEvent implements IPlayerTickEvent
    {
        
        private final net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent playerTickEvent;

        private Player(final net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent forgeTickEvent)
        {
            super(forgeTickEvent);
            playerTickEvent = forgeTickEvent;
        }

        public static IPlayerTickEvent fromForge(net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent tickEvent)
        {
            if (tickEvent instanceof ITickEvent)
                return (IPlayerTickEvent) tickEvent;

            if (tickEvent == null)
                return null;

            return new Player(tickEvent);
        }

        public static net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent asForge(IPlayerTickEvent event)
        {
            if (event instanceof net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent)
                return (net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent) event;

            if (event == null)
                return null;

            if (!(event instanceof IForgeJVoxelizerWrapper))
                throw new IllegalArgumentException("PlayerTickEvent is not a wrapper.");

            return ((IForgeJVoxelizerWrapper) event).getForgeInstance();
        }

        @Override
        public IPlayerEntity getPlayer()
        {
            return PlayerEntity.fromForge(playerTickEvent.player);
        }
    }

    public static class Render extends TickEvent implements IRenderTickEvent
    {
        private final net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent renderTickEvent;

        private Render(final net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent forgeTickEvent)
        {
            super(forgeTickEvent);
            renderTickEvent = forgeTickEvent;
        }

        public static IRenderTickEvent fromForge(net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent tickEvent)
        {
            if (tickEvent instanceof ITickEvent)
                return (IRenderTickEvent) tickEvent;

            if (tickEvent == null)
                return null;

            return new Render(tickEvent);
        }

        public static net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent asForge(IRenderTickEvent event)
        {
            if (event instanceof net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent)
                return (net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent) event;

            if (event == null)
                return null;

            if (!(event instanceof IForgeJVoxelizerWrapper))
                throw new IllegalArgumentException("RenderTickEvent is not a wrapper.");

            return ((IForgeJVoxelizerWrapper) event).getForgeInstance();
        }

        @Override
        public float getPartialTickTime()
        {
            return renderTickEvent.renderTickTime;
        }
    }
}
