package com.ldtteam.minelaunch.util;

public interface IIdentifierProvider
{

    IIdentifier provide(String domain, String path);

    IIdentifier provide(String string);
}
