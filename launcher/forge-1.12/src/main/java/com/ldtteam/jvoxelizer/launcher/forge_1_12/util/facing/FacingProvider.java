package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.facing;

import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.facing.IFacingProvider;
import net.minecraft.util.EnumFacing;

public class FacingProvider implements IFacingProvider
{
    private static FacingProvider ourInstance = new FacingProvider();

    public static FacingProvider getInstance()
    {
        return ourInstance;
    }

    private FacingProvider()
    {
    }

    @Override
    public IFacing getNorth()
    {
        return Facing.fromForge(EnumFacing.NORTH);
    }

    @Override
    public IFacing getSouth()
    {
        return Facing.fromForge(EnumFacing.SOUTH);
    }

    @Override
    public IFacing getWest()
    {
        return Facing.fromForge(EnumFacing.WEST);
    }

    @Override
    public IFacing getEast()
    {
        return Facing.fromForge(EnumFacing.EAST);
    }

    @Override
    public IFacing getUp()
    {
        return Facing.fromForge(EnumFacing.UP);
    }

    @Override
    public IFacing getDown()
    {
        return Facing.fromForge(EnumFacing.DOWN);
    }

    @Override
    public IFacing getNone()
    {
        return Facing.fromForge(null);
    }
}
