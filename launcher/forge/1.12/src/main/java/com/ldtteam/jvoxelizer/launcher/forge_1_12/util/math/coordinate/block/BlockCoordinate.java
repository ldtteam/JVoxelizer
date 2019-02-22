package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block;

import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import net.minecraft.util.math.BlockPos;

public class BlockCoordinate implements IBlockCoordinate {
    private BlockPos forgeIBlockCoordinate;

    public BlockCoordinate(BlockPos forgeIBlockCoordinate) {
        this.forgeIBlockCoordinate = forgeIBlockCoordinate;
    }

    @Override
    public int getX() {
        return forgeIBlockCoordinate.getX();
    }

    @Override
    public int getY() {
        return forgeIBlockCoordinate.getY();
    }

    @Override
    public int getZ() {
        return forgeIBlockCoordinate.getZ();
    }
}
