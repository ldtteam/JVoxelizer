package com.ldtteam.jvoxelizer.entity.living.player;

import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.inventory.IContainer;
import com.ldtteam.jvoxelizer.inventory.IContainerListener;
import com.ldtteam.jvoxelizer.inventory.IInventoryPlayer;

/**
 * Represents a player in the game.
 */
public interface IPlayerEntity extends ILivingBaseEntity, IContainerListener
{

    /**
     * The inventory of the player.
     *
     * @return The inventory of the player.
     */
    IInventoryPlayer getInventory();

    /**
     * The container that the player has open.
     *
     * @return The container that the player has open, or null.
     */
    IContainer<?> getOpenContainer();

    /**
     * Sets the container that the player has open.
     *
     * @param container The new container that the player has open, null closes the currently open container.
     * @return The player entity upon which this was called.
     */
    IPlayerEntity setOpenContainer(IContainer<?> container);
}
