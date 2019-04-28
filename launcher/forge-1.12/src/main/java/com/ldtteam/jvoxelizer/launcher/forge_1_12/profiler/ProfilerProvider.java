package com.ldtteam.jvoxelizer.launcher.forge_1_12.profiler;

import com.ldtteam.jvoxelizer.profiler.IProfiler;
import com.ldtteam.jvoxelizer.profiler.IProfilerProvider;

public class ProfilerProvider implements IProfilerProvider
{
    private static ProfilerProvider ourInstance = new ProfilerProvider();

    public static ProfilerProvider getInstance()
    {
        return ourInstance;
    }

    private ProfilerProvider()
    {
    }

    @Override
    public IProfiler provide()
    {
        return Profiler.fromForge(new net.minecraft.profiler.Profiler());
    }
}
