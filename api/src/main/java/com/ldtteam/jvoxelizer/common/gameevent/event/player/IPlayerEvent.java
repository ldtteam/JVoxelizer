package com.ldtteam.jvoxelizer.common.gameevent.event.player;

import com.ldtteam.jvoxelizer.entity.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.event.IEvent;
import com.ldtteam.jvoxelizer.inventory.IInventoryContainer;

/**
 * An event descriptor used to handle events that are related to a player.
 */
public interface IPlayerEvent extends IEvent
{
    IPlayerEntity getPlayer();

    /**
     * Triggered when the player logs out of the game or server.
     */
    interface IPlayerLoggedOutEvent extends IPlayerEvent
    {
    }

    interface IPlayerContainerEvent extends IPlayerEvent
    {
        IInventoryContainer getContainer();

        interface IOpen extends IPlayerContainerEvent
        {
            static IOpen create(IPlayerEntity player, IInventoryContainer container)
            {
                return IPlayerEventProviderHolder.getInstance().provideContainerOpenEvent(player, container);
            }
        }
    }

}
