package com.ldtteam.jvoxelizer.common.gameevent;

import com.ldtteam.jvoxelizer.entity.item.IItemStackEntity;
import com.ldtteam.jvoxelizer.entity.player.IPlayerEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;

/**
 * An event descriptor used to handle events that are related to a player.
 */
public interface IPlayerEvent
{
    IPlayerEntity getPlayer();

    /**
     * Triggered when an item is picked up by a player.
     */
    interface IItemStackPickupEvent extends IPlayerEvent
    {
        /**
         * The {@link IItemStackEntity} from whom the {@link IItemStack} is being picked up by the {@link IPlayerEntity}
         *
         * @return The {@link IItemStackEntity} from which is being picked up.
         */
        IItemStackEntity getPickedUpEntity();

        /**
         * The {@link IItemStack} that is being picked up by {@link IPlayerEntity}.
         *
         * @return The {@link IItemStack} that is being picked up.
         */
        default IItemStack getPickedUpItemStack()
        {
            return getPickedUpEntity().getItemStack();
        }
    }

    /**
     * Triggered when the player logs out of the game or server.
     */
    interface IPlayerLoggedOutEvent extends IPlayerEvent
    {
    }

}
