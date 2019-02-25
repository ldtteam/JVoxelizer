package com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension;

import com.ldtteam.jvoxelizer.dimension.IDimension;
import net.minecraft.world.World;

public class Dimension<I> extends DimensionReader<I> implements IDimension<I>
{
    private final World forgeWorld;

    public Dimension(final World world)
    {
        super(world);
        this.forgeWorld = world;
    }

    @Override
    public int getId()
    {
        return forgeWorld.provider.getDimension();
    }

    public World getForgeWorld()
    {
        return forgeWorld;
    }
}
