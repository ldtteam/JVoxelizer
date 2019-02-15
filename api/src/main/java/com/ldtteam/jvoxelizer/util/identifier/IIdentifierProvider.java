package com.ldtteam.jvoxelizer.util.identifier;

public interface IIdentifierProvider
{

    IIdentifier provide(String domain, String path);

    IIdentifier provide(String string);
}
