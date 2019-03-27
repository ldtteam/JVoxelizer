package com.ldtteam.jvoxelizer.progressmanager;

public interface IProgressManagerProvider
{
    IProgressBar push(String name, int size);

    void pop(IProgressBar bar);
}
