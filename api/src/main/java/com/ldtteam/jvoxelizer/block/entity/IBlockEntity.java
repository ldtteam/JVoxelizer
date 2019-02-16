package com.ldtteam.jvoxelizer.block.entity;

import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import com.ldtteam.jvoxelizer.world.IDimension;

public interface IBlockEntity
{

    IDimension getDimension();

    IBlockCoordinate getPosition();
}
