package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block;

import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import net.minecraft.util.math.BlockPos;

public class BlockCoordinate implements IBlockCoordinate {
    private BlockPos forgeBlockPos;

    public BlockCoordinate(BlockPos forgeBlockPos) {
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

    public BlockPos getForgeBlockPos()
    {
        return forgeBlockPos;
    }
}
