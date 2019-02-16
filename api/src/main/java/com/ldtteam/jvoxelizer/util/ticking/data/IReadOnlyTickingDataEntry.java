package com.ldtteam.jvoxelizer.util.ticking.data;

import com.ldtteam.jvoxelizer.entity.IEntity;

/**
 * Represents a data entry on a ticked object that holds the current and the previous entry.
 * An example would be the position of an {@link IEntity}.
 *
 * @param <T> The type stored in the entry.
 */
public interface IReadOnlyTickingDataEntry<T>
{
    /**
     * The previous value.
     *
     * @return the previous value.
     */
    T getPrevious();

    /**
     * The current value.
     *
     * @return the current value.
     */
    T getCurrent();
}
