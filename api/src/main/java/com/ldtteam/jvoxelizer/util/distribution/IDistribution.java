package com.ldtteam.jvoxelizer.util.distribution;

/**
 * This interface defines objects that describe in which distribution the game is run under.
 */
public interface IDistribution
{

    static IDistribution client()
    {
        return IDistributionProviderHolder.getInstance().provideClient();
    }

    static IDistribution server()
    {
        return IDistributionProviderHolder.getInstance().provideServer();
    }

    /**
     * Indicates if this distribution is the dedicated server.
     * In other words, if graphical capabilities are present or not.
     *
     * @return {@code True} when this is the dedicated server and graphical capabilities are not present, {@code false} when not.
     */
    boolean isDedicatedServer();

    /**
     * Indicates if this distribution is the client.
     * Guarantees the availability of graphical clients.
     *
     * @return {@code True} when this is the client and graphical capabilities are present, {@code false} when not.
     */
    boolean isClient();
}
