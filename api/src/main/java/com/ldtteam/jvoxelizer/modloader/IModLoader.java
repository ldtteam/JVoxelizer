package com.ldtteam.jvoxelizer.modloader;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;

public interface IModLoader
{
    static IModLoader instance()
    {
        return IModLoaderProviderHolder.getInstance().provide();
    }

    List<IMod> getActiveModList();
}
