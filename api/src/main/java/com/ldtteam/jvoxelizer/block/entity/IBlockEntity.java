package com.ldtteam.jvoxelizer.block.entity;

import com.ldtteam.jvoxelizer.common.capability.provider.ICapabilityProvider;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import com.ldtteam.jvoxelizer.dimension.IDimension;

/**
 * Represents a ticking entity that is connected to a block and cannot move.
 *
 * The entity can hold capabilities and such would need to be queried to get specific functions.
 */
public interface IBlockEntity extends ICapabilityProvider
{
    /**
     * The dimension the entity is in.
     *
     * @return The dimension containing the entity.
     */
    IDimension getDimension();

    /**
     * The position of the entity inside the dimension.
     *
     * @return The position of the entitiy.
     */
    IBlockCoordinate getPosition();
}
