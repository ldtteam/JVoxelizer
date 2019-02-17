package com.ldtteam.jvoxelizer.threading;

import com.google.common.util.concurrent.ListenableFuture;
import com.ldtteam.jvoxelizer.IGameEngine;

/**
 * Executes tasks on the thread it is assigned.
 */
public interface IExecutor
{

    /**
     * Registers a new {@link Runnable} to be executed next tick.
     *
     * @param runnableToSchedule The code to execute.
     *
     * @return A {@link ListenableFuture} object to monitor for progress.
     */
    ListenableFuture<Object> queue(Runnable runnableToSchedule);

    /**
     * Indicates if the caller of this method is on the primary thread of the {@link IGameEngine}

     * @return {@code True} when the caller is on the game engine thread, {@code false} when not.
     */
    boolean isCallingFromGameEngineThread();
}
