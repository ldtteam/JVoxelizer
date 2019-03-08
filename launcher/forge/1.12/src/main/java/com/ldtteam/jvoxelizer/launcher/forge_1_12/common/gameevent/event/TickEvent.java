package com.ldtteam.jvoxelizer.launcher.forge_1_12.common.gameevent.event;

import com.ldtteam.jvoxelizer.common.gameevent.event.ITickEvent;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.util.distribution.IDistribution;

public abstract class TickEvent implements ITickEvent
{
    private final IDistribution distribution;
    private final Phase phase;

    protected TickEvent(final IDistribution distribution, final Phase phase) {
        this.distribution = distribution;
        this.phase = phase;
    }

    /**
     * The {@link IDistribution} under which this {@link ITickEvent} was fired.
     *
     * @return The {@link IDistribution}.
     */
    @Override
    public IDistribution getDistribution()
    {
        return distribution;
    }

    /**
     * The {@link Phase} for which this {@link ITickEvent} was fired.
     *
     * @return The {@link Phase}.
     */
    @Override
    public Phase getPhase()
    {
        return phase;
    }

    public static class ServerTickEvent extends TickEvent implements IServerTickEvent
    {
        private ServerTickEvent(final Phase phase)
        {
            super(IDistribution.server(), phase);
        }
    }

    public static class ClientTickEvent extends TickEvent implements IClientTickEvent
    {

        private ClientTickEvent(final Phase phase)
        {
            super(IDistribution.client(), phase);
        }
    }

    public static class DimensionTickEvent extends TickEvent implements IDimensionTickEvent
    {

        private final IDimension<?> dimension;

        private DimensionTickEvent(final IDistribution distribution, final Phase phase, final IDimension<?> dimension)
        {
            super(distribution, phase);
            this.dimension = dimension;
        }

        /**
         * The {@link IDimension} that is being ticked.
         *
         * @return The {@link IDimension}.
         */
        @Override
        public IDimension getDimension()
        {
            return dimension;
        }
    }

    public static class PlayerTickEvent extends TickEvent implements IPlayerTickEvent
    {

        private final IPlayerEntity playerEntity;

        private PlayerTickEvent(final IDistribution distribution, final Phase phase, final IPlayerEntity playerEntity)
        {
            super(distribution, phase);
            this.playerEntity = playerEntity;
        }

        @Override
        public IPlayerEntity getPlayer()
        {
            return playerEntity;
        }
    }

    public static class RenderTickEvent extends TickEvent implements IRenderTickEvent
    {

        private final float partialTickTime;

        protected RenderTickEvent(final Phase phase, final float partialTickTime)
        {
            super(IDistribution.client(), phase);
            this.partialTickTime = partialTickTime;
        }

        /**
         * A value between 0 and 1 indicating how far along we are between two ticks.
         * Allows for interpolation of animations and movements between update ticks.
         *
         * @return The amount of time that has already passed between the last tick and the next, on a scale of 0 to 1.
         */
        @Override
        public float getPartialTickTime()
        {
            return partialTickTime;
        }
    }
}
