package com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.dimension.IDimensionProvider;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class DimensionProvider implements IDimensionProvider
{
    private static DimensionProvider ourInstance = new DimensionProvider();

    public static DimensionProvider getInstance()
    {
        return ourInstance;
    }

    private DimensionProvider()
    {
    }

    @Override
    public IDimension provide(final int id)
    {
        return Dimension.fromForge(ServerLifecycleHooks.getCurrentServer().getWorld(DimensionType.getById(id)));
    }
}
