package com.ldtteam.jvoxelizer.progressmanager;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface IProgressManager
{

    static IProgressBar push(String name, int size)
    {
        throw new NotImplementedException();
    }

    static void pop(IProgressBar bar)
    {
        throw new NotImplementedException();
    }
}
