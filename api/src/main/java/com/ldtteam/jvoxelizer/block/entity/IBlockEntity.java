package com.ldtteam.jvoxelizer.block.entity;

import com.ldtteam.jvoxelizer.common.capability.ICapabilityProvider;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import com.ldtteam.jvoxelizer.dimension.IDimension;

public interface IBlockEntity extends ICapabilityProvider
{

    IDimension getDimension();

    IBlockCoordinate getPosition();
}
