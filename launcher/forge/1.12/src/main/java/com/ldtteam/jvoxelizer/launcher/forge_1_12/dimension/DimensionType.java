package com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension;

import com.ldtteam.jvoxelizer.dimension.IDimensionType;
import net.minecraft.world.WorldType;

public class DimensionType implements IDimensionType
{

    private final WorldType forgeWorldType;

    public DimensionType(final WorldType forgeWorldType) {this.forgeWorldType = forgeWorldType;}

    public WorldType getForgeWorldType()
    {
        return forgeWorldType;
    }
}
