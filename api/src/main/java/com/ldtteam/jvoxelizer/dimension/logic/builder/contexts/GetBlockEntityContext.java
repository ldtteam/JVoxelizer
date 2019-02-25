package com.ldtteam.jvoxelizer.dimension.logic.builder.contexts;

import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

public class GetBlockEntityContext {

    public GetBlockEntityContext(IBlockCoordinate pos) {
        this.pos = pos;
    }

    private IBlockCoordinate pos;

    public IBlockCoordinate getPos() {
        return pos;
    }

    public void setPos(IBlockCoordinate pos) {
        this.pos = pos;
    }
}
