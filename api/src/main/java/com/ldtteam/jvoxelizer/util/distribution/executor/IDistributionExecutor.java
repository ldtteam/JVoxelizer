package com.ldtteam.jvoxelizer.util.distribution.executor;

import com.ldtteam.jvoxelizer.util.distribution.IDistribution;

import java.util.function.Supplier;

public interface IDistributionExecutor
{
    /**
     * Method used to specific code on the server and the client {@link IDistribution}.
     *
     * @param clientSide The code that needs to be run on the client {@link IDistribution}.
     * @param serverSide The code that needs to be run on the server {@link IDistribution}.
     */
    static void on(final Runnable clientSide, final Runnable serverSide)
    {
        onClient(clientSide);
        onServer(serverSide);
    }

    /**
     * Method used to only run code on the clien {@link IDistribution}t.
     *
     * @param runnable The code that needs to be run on the client {@link IDistribution} only.
     */
    static void onClient(final Runnable runnable)
    {
        IDistributionExectorHolder.getInstance().runOnClient(runnable);
    }

    /**
     * Method used to only run code on the server {@link IDistribution}.
     *
     * @param runnable The code that needs to be run on the server {@link IDistribution} only.
     */
    static void onServer(final Runnable runnable)
    {
        IDistributionExectorHolder.getInstance().runOnServer(runnable);
    }

    /**
     * A {@link Supplier} version of {@link #on(Runnable, Runnable)}.
     *
     * @param clientSide The {@link Supplier} that executes on the client {@link IDistribution}.
     * @param serverSide The {@link Supplier} that executes on the server {@link IDistribution}.
     * @param <T>        The type that is produced.
     * @return The value from the client or the server {@link IDistribution}.
     */
    static <T> T on(final Supplier<T> clientSide, final Supplier<T> serverSide)
    {
        return IDistributionExectorHolder.getInstance().runOn(clientSide, serverSide);
    }

    /**
     * Method used to only run code on the clien {@link IDistribution}t.
     *
     * @param runnable The code that needs to be run on the client {@link IDistribution} only.
     */
    void runOnClient(final Runnable runnable);

    /**
     * Method used to only run code on the server {@link IDistribution}.
     *
     * @param runnable The code that needs to be run on the server {@link IDistribution} only.
     */
    void runOnServer(final Runnable runnable);

    /**
     * A {@link Supplier} version of {@link #on(Runnable, Runnable)}.
     *
     * @param clientSide The {@link Supplier} that executes on the client {@link IDistribution}.
     * @param serverSide The {@link Supplier} that executes on the server {@link IDistribution}.
     * @param <T>        The type that is produced.
     * @return The value from the client or the server {@link IDistribution}.
     */
    <T> T runOn(final Supplier<T> clientSide, final Supplier<T> serverSide);
}