package com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension;

import com.ldtteam.jvoxelizer.dimension.IDimensionType;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import net.minecraft.world.WorldType;

public class DimensionType implements IDimensionType, IForgeJVoxelizerWrapper
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
        {
            return (WorldType) dimensionType;
        }

        if (dimensionType == null)
        {
            return null;
        }

        if (!(dimensionType instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("DimensionType is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) dimensionType).getForgeInstance();
    }

    public static IDimensionType fromForge(WorldType worldType)
    {
        if (worldType instanceof IDimensionType)
        {
            return (IDimensionType) worldType;
        }

        return new DimensionType(worldType);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeWorldType();
    }
}
