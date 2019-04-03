package com.ldtteam.jvoxelizer.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.entity.living.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.event.IEvent;
import com.ldtteam.jvoxelizer.inventory.IContainer;

/**
 * An event descriptor used to handle events that are related to a player.
 */
public interface IPlayerEntityEvent extends IEvent
{
    IPlayerEntity getPlayer();

    /**
     * Triggered on an interaction of a player with the container
     */
    interface IContainerEvent extends IPlayerEntityEvent
    {
        IContainer<?> getContainer();

        interface IOpen extends IContainerEvent
        {
            static IOpen create(IPlayerEntity player, IContainer<?> container)
            {
                return IPlayerEntityEventProviderHolder.getInstance().provideContainerOpenEvent(player, container);
            }
        }

        interface IClose extends IContainerEvent
        {
            static IClose create(IPlayerEntity player, IContainer<?> container)
            {
                return IPlayerEntityEventProviderHolder.getInstance().provideContainerCloseEvent(player, container);
            }
        }
    }

}
