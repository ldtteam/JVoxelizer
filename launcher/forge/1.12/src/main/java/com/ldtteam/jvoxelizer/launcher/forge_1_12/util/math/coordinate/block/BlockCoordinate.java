package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block;

import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import net.minecraft.util.math.BlockPos;

public class BlockCoordinate implements IBlockCoordinate {
    private BlockPos forgeBlockPos;

    private BlockCoordinate(BlockPos forgeBlockPos) {
        this.forgeBlockPos = forgeBlockPos;
    }

    @Override
    public int getX() {
        return forgeBlockPos.getX();
    }

    @Override
    public int getY() {
        return forgeBlockPos.getY();
    }

    @Override
    public int getZ() {
        return forgeBlockPos.getZ();
    }

    private BlockPos getForgeBlockPos()
    {
        return forgeBlockPos;
    }

    public static BlockPos asForge(IBlockCoordinate blockCoordinate)
    {
        if (blockCoordinate instanceof BlockPos)
            return (BlockPos) blockCoordinate;

        return ((BlockCoordinate) blockCoordinate).getForgeBlockPos();
    }

    public static IBlockCoordinate fromForge(BlockPos blockPos)
    {
        if (blockPos instanceof IBlockCoordinate)
            return (IBlockCoordinate) blockPos;

        return new BlockCoordinate(blockPos);
    }
}
