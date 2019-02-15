package com.ldtteam.minelaunch.util;

/**
 * Represents an identifier of a on disk / in jar resource.
 */
public interface IIdentifier
{

    /**
     * The domain the resource is in.
     *
     * @return The domain.
     */
    String getDomain();

    /**
     * The path the resource is in under the domain specified in {@link #getDomain()}
     *
     * @return The path.
     */
    String getPath();
}
