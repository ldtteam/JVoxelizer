package com.ldtteam.jvoxelizer.launcher.forge_1_12.threading;

import com.google.common.util.concurrent.ListenableFuture;
import com.ldtteam.jvoxelizer.threading.IExecutor;
import net.minecraft.util.IThreadListener;

public class Executor implements IExecutor
{

    private final IThreadListener threadListener;

    private Executor(final IThreadListener threadListener) {this.threadListener = threadListener;}

    @Override
    public ListenableFuture<Object> queue(final Runnable runnableToSchedule)
    {
        return threadListener.addScheduledTask(runnableToSchedule);
    }

    @Override
    public boolean isCallingFromGameEngineThread()
    {
        return threadListener.isCallingFromMinecraftThread();
    }

    private IThreadListener getThreadListener()
    {
        return threadListener;
    }

    public static IThreadListener asForge(IExecutor executor)
    {
        if (executor instanceof IThreadListener)
            return (IThreadListener) executor;

        return ((Executor) executor).getThreadListener();
    }

    public static IExecutor fromForge(IThreadListener threadListener)
    {
        if (threadListener instanceof IExecutor)
            return (IExecutor) threadListener;

        return new Executor(threadListener);
    }
}
