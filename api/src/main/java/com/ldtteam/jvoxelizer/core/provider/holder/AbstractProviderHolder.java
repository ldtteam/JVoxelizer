package com.ldtteam.jvoxelizer.core.provider.holder;

/**
 * An abstract class that will handle the lookup of providers using their names.
 *
 * @param <P> The type of the provider to look for.
 */
public abstract class AbstractProviderHolder<P>
{

    private final String providedName;
    private final P provider;

    public AbstractProviderHolder(final String providedName) {
        this.providedName = providedName;
        provider = null;
    }

    /**
     * Returns the resolved provider.
     *
     * @return The provider
     * @throws IllegalStateException when the provider could not be resolved.
     */
    protected P getProvider() throws IllegalStateException
    {
        if (provider == null) throw new IllegalArgumentException("The " + providedName + " has not been initialized");

        return provider;
    }
}
