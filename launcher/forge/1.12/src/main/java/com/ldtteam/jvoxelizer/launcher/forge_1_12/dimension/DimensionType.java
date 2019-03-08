package com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension;

import com.ldtteam.jvoxelizer.dimension.IDimensionType;
import net.minecraft.world.WorldType;

public class DimensionType implements IDimensionType
{

    private final WorldType forgeWorldType;

    private DimensionType(final WorldType forgeWorldType) {this.forgeWorldType = forgeWorldType;}

    private WorldType getForgeWorldType()
    {
        return forgeWorldType;
    }

    public static WorldType asForge(IDimensionType dimensionType)
    {
        if (dimensionType instanceof WorldType)
            return (WorldType) dimensionType;

        return ((DimensionType) dimensionType).getForgeWorldType();
    }

    public static IDimensionType fromForge(WorldType worldType)
    {
        if (worldType instanceof IDimensionType)
            return (IDimensionType) worldType;

        return new DimensionType(worldType);
    }
}
