package com.ldtteam.jvoxelizer.core.provider.holder;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Handles resolving and registration of logic providers that bridge gaps between JVox and its implementations.
 */
public class ProviderResolver
{
    private static ProviderResolver ourInstance = new ProviderResolver();

    public static ProviderResolver getInstance()
    {
        return ourInstance;
    }

    private final Map<String, Object> providerMap = Maps.newHashMap();

    private ProviderResolver()
    {
    }

    public void registerProvider(final String name, final Object provider)
    {
        providerMap.put(name, provider);
    }

    public void registerProvider(final Class<?> name, final Object provider)
    {
        this.registerProvider(name.getName(), provider);
    }

    public Object getProvider(final String name)
    {
        return providerMap.get(name);
    }
}
