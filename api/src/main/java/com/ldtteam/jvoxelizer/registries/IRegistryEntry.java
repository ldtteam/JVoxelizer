package com.ldtteam.jvoxelizer.registries;

import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public interface IRegistryEntry<V>
{
    V setRegistryName(IIdentifier name);

    IIdentifier getRegistryName();

    Class<? extends V> getRegistryType();
}
