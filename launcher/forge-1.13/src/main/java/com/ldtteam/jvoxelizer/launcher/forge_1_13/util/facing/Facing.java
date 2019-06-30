package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.facing;

import com.ldtteam.jvoxelizer.util.facing.IFacing;
import net.minecraft.util.EnumFacing;

public class Facing implements IFacing
{
    private EnumFacing forgeSide;

    private Facing(final EnumFacing forgeSide)
    {
        this.forgeSide = forgeSide;
    }

    @Override
    public boolean isNorth()
    {
        return forgeSide == EnumFacing.NORTH;
    }

    @Override
    public boolean isSouth()
    {
        return forgeSide == EnumFacing.SOUTH;
    }

    @Override
    public boolean isWest()
    {
        return forgeSide == EnumFacing.WEST;
    }

    @Override
    public boolean isEast()
    {
        return forgeSide == EnumFacing.EAST;
    }

    @Override
    public boolean isUp()
    {
        return forgeSide == EnumFacing.UP;
    }

    @Override
    public boolean isDown()
    {
        return forgeSide == EnumFacing.DOWN;
    }

    @Override
    public boolean isNone()
    {
        return forgeSide == null;
    }

    private EnumFacing getForgeSide()
    {
        return forgeSide;
    }

    public static EnumFacing asForge(IFacing facing)
    {
        if ( facing == null )
        {
            return null;
        }
        return ((Facing) facing).getForgeSide();
    }

    public static IFacing fromForge(EnumFacing facing)
    {
        if ( facing == null )
        {
            return null;
        }
        return new Facing(facing);
    }
}
