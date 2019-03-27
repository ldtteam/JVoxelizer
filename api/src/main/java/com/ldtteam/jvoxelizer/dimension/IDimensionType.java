package com.ldtteam.jvoxelizer.dimension;

public interface IDimensionType
{

    static IDimensionType getDefault()
    {
        return IDimensionTypeProviderHolder.getInstance().provideDefault();
    }
}
