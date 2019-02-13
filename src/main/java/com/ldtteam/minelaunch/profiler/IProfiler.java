package com.ldtteam.minelaunch.profiler;

import com.sun.istack.internal.NotNull;

/**
 * Represents a section based profiler.
 * Allows for performance testing of components.
 */
public interface IProfiler
{
    /**
     * Starts a new (sub)section.
     *
     * @param name The name of the section to start.
     */
    void startSection(@NotNull final String name);

    /**
     * Ends the previous section.
     */
    void endSection();
}
