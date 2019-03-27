package com.ldtteam.jvoxelizer.modloader;

import java.util.List;

public interface IModLoader
{
    static IModLoader instance()
    {
        return IModLoaderProviderHolder.getInstance().provide();
    }

    List<IMod> getActiveModList();
}
