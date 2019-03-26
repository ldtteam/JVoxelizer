package com.ldtteam.jvoxelizer.registries;

import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public interface IRegistryEntry<V>
{
    V setRegistryIdentifier(IIdentifier name);

    IIdentifier getRegistryIdentifier();

    Class getTypeUsedForRegistration();
}
