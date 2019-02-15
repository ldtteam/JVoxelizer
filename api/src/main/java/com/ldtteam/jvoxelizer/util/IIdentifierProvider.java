package com.ldtteam.jvoxelizer.util;

public interface IIdentifierProvider
{

    IIdentifier provide(String domain, String path);

    IIdentifier provide(String string);
}
