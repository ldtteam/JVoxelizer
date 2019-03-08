package com.ldtteam.jvoxelizer.core.logic;

/**
 * Represents an object that is managed by the game and that holds additional data per instance.
 *
 * @param <T> The type of the data per instance.
 */
public interface IInstancedObject<T>
{

    T getInstanceData();
}
