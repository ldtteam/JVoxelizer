package com.ldtteam.jvoxelizer.block.entity;

import com.ldtteam.jvoxelizer.util.math.ICoordinate;
import com.ldtteam.jvoxelizer.world.IDimension;

public interface IBlockEntity
{

    IDimension getDimension();

    ICoordinate getPosition();
}
