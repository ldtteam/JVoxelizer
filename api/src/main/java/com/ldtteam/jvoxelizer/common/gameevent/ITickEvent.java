package com.ldtteam.jvoxelizer.common.gameevent;

import com.ldtteam.jvoxelizer.entity.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.util.distribution.IDistribution;
import com.ldtteam.jvoxelizer.world.IDimension;

/**
 * An event descriptor used to handle updates to several different types.
 */
public interface ITickEvent
{
    /**
     * The phase of the tick.
     */
    enum Phase
    {
        /**
         * Before the object in question gets updated.
         */
        START,

        /**
         * After the object in question has been updated.
         */
        END;
    }

    /**
     * The {@link IDistribution} under which this {@link ITickEvent} was fired.
     *
     * @return The {@link IDistribution}.
     */
    IDistribution getDistribution();

    /**
     * The {@link Phase} for which this {@link ITickEvent} was fired.
     * @return The {@link Phase}.
     */
    Phase getPhase();

    /**
     * Ticked when the server is updated.
     */
    interface IServerTickEvent extends ITickEvent
    {
    }

    /**
     * Ticked when the client is updated.
     */
    interface IClientTickEvent extends ITickEvent
    {
    }

    /**
     * Ticked when a specific dimension is updated.
     */
    interface IDimensionTickEvent extends ITickEvent
    {
        /**
         * The {@link IDimension} that is being ticked.
         *
         * @return The {@link IDimension}.
         */
        IDimension getDimension();
    }

    /**
     * Ticked when a specific player is updated.
     */
    interface IPlayerTickEvent extends ITickEvent
    {
        IPlayerEntity getPlayer();
    }

    /**
     * Ticked every time a frame is rendered.
     */
    interface RenderTickEvent extends ITickEvent
    {
        /**
         * A value between 0 and 1 indicating how far along we are between two ticks.
         * Allows for interpolation of animations and movements between update ticks.
         *
         * @return The amount of time that has already passed between the last tick and the next, on a scale of 0 to 1.
         */
        float getPartialTickTime();
    }
}
