package com.ldtteam.jvoxelizer.launcher.forge_1_12.profiler;

import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.profiler.IProfiler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class Profiler implements IProfiler, IForgeJVoxelizerWrapper
{
    private net.minecraft.profiler.Profiler profiler;

    private Profiler(final net.minecraft.profiler.Profiler profiler)
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
        this.profiler.profilingMap.clear();
        this.profiler.profilingMap.putAll(profilingMap);
    }

    @Override
    public Map<String, Long> getProfilingMap()
    {
        return this.profiler.profilingMap;
    }

    @Override
    public void clearProfiling()
    {
        profiler.clearProfiling();
    }

    private net.minecraft.profiler.Profiler getProfiler()
    {
        return profiler;
    }

    public static net.minecraft.profiler.Profiler asForge(final IProfiler profiler)
    {
        if (profiler instanceof net.minecraft.profiler.Profiler)
        {
            return (net.minecraft.profiler.Profiler) profiler;
        }

        if (profiler == null)
        {
            return null;
        }

        if (!(profiler instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("Profiler is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) profiler).getForgeInstance();
    }

    public static IProfiler fromForge(final net.minecraft.profiler.Profiler profiler)
    {
        if (profiler instanceof IProfiler)
        {
            return (IProfiler) profiler;
        }

        return new Profiler(profiler);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getProfiler();
    }
}
