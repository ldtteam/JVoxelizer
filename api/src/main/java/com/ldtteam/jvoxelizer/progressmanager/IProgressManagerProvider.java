package com.ldtteam.jvoxelizer.progressmanager;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface IProgressManagerProvider
{
    IProgressBar push(String name, int size);

    void pop(IProgressBar bar);
}
