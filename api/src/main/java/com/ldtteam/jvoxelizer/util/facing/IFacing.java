package com.ldtteam.jvoxelizer.util.facing;

public interface IFacing
{

    static IFacing getNorth()
    {
        return IFacingProviderHolder.getInstance().getNorth();
    }

    static IFacing getSouth()
    {
        return IFacingProviderHolder.getInstance().getSouth();
    }

    static IFacing getWest()
    {
        return IFacingProviderHolder.getInstance().getWest();
    }

    static IFacing getEast()
    {
        return IFacingProviderHolder.getInstance().getEast();
    }

    static IFacing getUp()
    {
        return IFacingProviderHolder.getInstance().getUp();
    }

    static IFacing getDown()
    {
        return IFacingProviderHolder.getInstance().getDown();
    }

    static IFacing getNone()
    {
        return IFacingProviderHolder.getInstance().getNone();
    }

    boolean isNorth();

    boolean isSouth();

    boolean isWest();

    boolean isEast();

    boolean isUp();

    boolean isDown();

    boolean isNone();
}
