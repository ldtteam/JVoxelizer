package com.ldtteam.jvoxelizer.entity.living.player;

/**
 * Represents a player, playing in a multiplayer session.
 */
public interface IMultiplayerPlayerEntity extends IPlayerEntity
{
    /**
     * Increments the id of the next opened Gui
     */
    void incrementWindowId();

    /**
     * Closes the open container, if any is open.
     */
    void closeOpenContainer();

    /**
     * The current id of the open gui (if any is open, else the last is returned)
     *
     * @return The current id of the open gui (if any is open, else the last is returned)
     */
    int getCurrentWindowId();
}
