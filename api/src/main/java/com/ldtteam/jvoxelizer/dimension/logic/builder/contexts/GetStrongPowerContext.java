package com.ldtteam.jvoxelizer.dimension.logic.builder.contexts;

import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

public class GetStrongPowerContext {

    public GetStrongPowerContext(IBlockCoordinate pos, IFacing direction) {
        this.pos = pos;
        this.direction = direction;
    }

    private IBlockCoordinate pos;

    public IBlockCoordinate getPos() {
        return pos;
    }

    public void setPos(IBlockCoordinate pos) {
        this.pos = pos;
    }

    private IFacing direction;

    public IFacing getDirection() {
        return direction;
    }

    public void setDirection(IFacing direction) {
        this.direction = direction;
    }
}
