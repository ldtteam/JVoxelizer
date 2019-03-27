package com.ldtteam.jvoxelizer.profiler;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class IProfilerProviderHolder extends AbstractHolder<IProfilerProvider> implements IProfilerProvider
{
    private static IProfilerProviderHolder ourInstance = new IProfilerProviderHolder();

    public static IProfilerProviderHolder getInstance()
    {
        return ourInstance;
    }

    private IProfilerProviderHolder()
    {
        super(IProfiler.class.getName());
    }

    @Override
    public IProfiler provide()
    {
        return getProvider().provide();
    }
}