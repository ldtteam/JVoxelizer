package com.ldtteam.jvoxelizer.progressmanager;

public interface IProgressManager
{
    static IProgressBar push(String name, int size)
    {
        return IProgressManagerProviderHolder.getInstance().push(name, size);
    }

    static void pop(IProgressBar bar)
    {
        IProgressManagerProviderHolder.getInstance().pop(bar);
    }
}
