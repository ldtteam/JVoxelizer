package com.ldtteam.jvoxelizer.launcher.forge_1_12.profiler;

import com.ldtteam.jvoxelizer.profiler.IProfiler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class Profiler implements IProfiler
{
    private net.minecraft.profiler.Profiler profiler;

    public Profiler(final net.minecraft.profiler.Profiler profiler)
    {
        this.profiler = profiler;
    }

    @Override
    public void startSection(@NotNull final String name)
    {
        profiler.startSection(name);
    }

    @Override
    public void endSection()
    {
        profiler.endSection();
    }

    @Override
    public void enableProfiling()
    {
        profiler.profilingEnabled = true;
    }

    @Override
    public void disableProfiling()
    {
        profiler.profilingEnabled = false;
    }

    @Override
    public void setProfilingMap(final Map<String, Long> profilingMap)
    {
        //todo orion?
    }

    @Override
    public Map<String, Long> getProfilingMap()
    {
        //todo orion?
        return null;
    }

    @Override
    public void clearProfiling()
    {
        profiler.clearProfiling();
    }
}
