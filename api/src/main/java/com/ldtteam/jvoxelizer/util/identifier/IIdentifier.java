package com.ldtteam.jvoxelizer.util.identifier;

/**
 * Represents an identifier of a on disk / in jar resource.
 */
public interface IIdentifier
{

    /**
     * Creates a new identifier from its domain, and its path.
     * Depending on the underlying game logic these are concatenated somehow.
     *
     * @param domain The domain of the resource.
     * @param path The path inside that domain to the resource.
     *
     * @return The identifier targeting the specified resource.
     */
    static IIdentifier create(String domain, String path)
    {
        return IIdentifierProviderHolder.getInstance().provide(domain, path);
    }

    /**
     * Creates a new identifier from full path.
     *
     * @param string The  path to the resource.
     * @return The identifier targeting the specified resource.
     */
    static IIdentifier create(String string)
    {
        return IIdentifierProviderHolder.getInstance().provide(string);
    }

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
