package com.ldtteam.jvoxelizer.dimension.logic.builder.contexts;

import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

public class GetCombinedLightContext {

    public GetCombinedLightContext(IBlockCoordinate pos, int lightValue) {
        this.pos = pos;
        this.lightValue = lightValue;
    }

    private IBlockCoordinate pos;

    public IBlockCoordinate getPos() {
        return pos;
    }

    public void setPos(IBlockCoordinate pos) {
        this.pos = pos;
    }

    private int lightValue;

    public int getLightValue() {
        return lightValue;
    }

    public void setLightValue(int lightValue) {
        this.lightValue = lightValue;
    }
}
