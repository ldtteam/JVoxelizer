package com.ldtteam.jvoxelizer.core.provider.holder;

/**
 * An abstract class that will handle the lookup of providers using their names.
 *
 * @param <P> The type of the provider to look for.
 */
public abstract class AbstractHolder<P>
{

    private final String providedName;
    private final P provider;

    @SuppressWarnings("unchecked")
    public AbstractHolder(final String providedName) {
        this.providedName = providedName;
        provider = (P) ProviderResolver.getInstance().getProvider(providedName);
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
