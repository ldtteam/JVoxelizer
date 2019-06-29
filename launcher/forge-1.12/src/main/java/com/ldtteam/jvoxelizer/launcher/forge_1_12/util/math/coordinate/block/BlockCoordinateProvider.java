package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block;

import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinateProvider;
import net.minecraft.util.math.BlockPos;

public class BlockCoordinateProvider implements IBlockCoordinateProvider
{
    private static BlockCoordinateProvider ourInstance = new BlockCoordinateProvider();

    public static BlockCoordinateProvider getInstance()
    {
        return ourInstance;
    }

    private BlockCoordinateProvider()
    {
    }

    @Override
    public IBlockCoordinate provide(final int x, final int y, final int z)
    {
        return BlockCoordinate.fromForge(new BlockPos(x,y,z));
    }
}
