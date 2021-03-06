package com.ldtteam.jvoxelizer.profiler;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Represents a section based profiler.
 * Allows for performance testing of components.
 */
public interface IProfiler
{
    static IProfiler create()
    {
        return IProfilerProviderHolder.getInstance().provide();
    }

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

    void enableProfiling();

    void disableProfiling();

    void setProfilingMap(Map<String, Long> profilingMap);

    Map<String, Long> getProfilingMap();

    void clearProfiling();
}
