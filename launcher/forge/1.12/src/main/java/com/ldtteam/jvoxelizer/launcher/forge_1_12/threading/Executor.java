package com.ldtteam.jvoxelizer.launcher.forge_1_12.threading;

import com.google.common.util.concurrent.ListenableFuture;
import com.ldtteam.jvoxelizer.threading.IExecutor;

//todo orion
public class Executor implements IExecutor
{

    @Override
    public ListenableFuture<Object> queue(final Runnable runnableToSchedule)
    {
        return null;
    }

    @Override
    public boolean isCallingFromGameEngineThread()
    {
        return false;
    }
}
