package com.ldtteam.jvoxelizer.dimension.logic.builder.contexts;

import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

public class IsSideSolidContext {

    public IsSideSolidContext(IBlockCoordinate pos, IFacing side, boolean _default) {
        this.pos = pos;
        this.side = side;
        this._default = _default;
    }

    private IBlockCoordinate pos;

    public IBlockCoordinate getPos() {
        return pos;
    }

    public void setPos(IBlockCoordinate pos) {
        this.pos = pos;
    }

    private IFacing side;

    public IFacing getSide() {
        return side;
    }

    public void setSide(IFacing side) {
        this.side = side;
    }

    private boolean _default;

    public boolean get_default() {
        return _default;
    }

    public void set_default(boolean _default) {
        this._default = _default;
    }
}
