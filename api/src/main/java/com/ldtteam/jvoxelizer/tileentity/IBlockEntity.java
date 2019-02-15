package com.ldtteam.jvoxelizer.tileentity;

import com.ldtteam.jvoxelizer.util.math.ICoordinate;
import com.ldtteam.jvoxelizer.world.IDimension;

public interface IBlockEntity
{

    IDimension getDimension();

    ICoordinate getPosition();
}
