package com.ldtteam.jvoxelizer.util.ticking.data;

/**
 * Represents the read and write variant of {@link IReadOnlyTickingDataEntry}
 *
 * @param <T> The type of the entry.
 */
public interface ITickingDataEntry<T> extends IReadOnlyTickingDataEntry<T>
{
    /**
     * Sets the previous value.
     *
     * @param previous The new previous value.
     * @return The instance of {@link ITickingDataEntry} this was called upon.
     */
    ITickingDataEntry<T> setPrevious(T previous);

    /**
     * Sets the current value.
     *
     * @param current The new current value.
     * @return The instance of {@link ITickingDataEntry} this was called upon.
     */
    ITickingDataEntry<T> setCurrent(T current);

    /**
     * Updates the current value, making the current value the previous value, and discarding the previous value.
     *
     * @param current The new current value.
     * @return The instance of {@link ITickingDataEntry} this was called upon.
     */
    default ITickingDataEntry<T> update(T current)
    {
        return setPrevious(getCurrent()).setCurrent(current);
    }
}
