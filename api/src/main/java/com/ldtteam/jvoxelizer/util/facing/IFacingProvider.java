package com.ldtteam.jvoxelizer.util.facing;

public interface IFacingProvider
{
    IFacing getNorth();

    IFacing getSouth();

    IFacing getWest();

    IFacing getEast();

    IFacing getUp();

    IFacing getDown();

    IFacing getNone();
}
