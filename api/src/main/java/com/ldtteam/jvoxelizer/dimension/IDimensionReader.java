package com.ldtteam.jvoxelizer.dimension;

import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.core.logic.*;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

public interface IDimensionReader<I> extends IInstancedObject<I> {

    IBlockEntity getBlockEntity(IBlockCoordinate pos);

    int getCombinedLight(IBlockCoordinate pos, int lightValue);

    IBlockState getBlockState(IBlockCoordinate pos);

    boolean isAirBlock(IBlockCoordinate pos);

    IBiome getBiome(IBlockCoordinate pos);

    int getStrongPower(IBlockCoordinate pos, IFacing direction);

    IDimensionType getDimensionType();

    boolean isSideSolid(IBlockCoordinate pos, IFacing side, boolean _default);
}
