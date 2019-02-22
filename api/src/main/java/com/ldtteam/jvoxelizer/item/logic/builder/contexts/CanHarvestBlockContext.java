package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.block.state.IBlockState;

public class CanHarvestBlockContext {

    public CanHarvestBlockContext(IBlockState blockIn) {
        this.blockIn = blockIn;
    }

    private IBlockState blockIn;

    public IBlockState getBlockIn() {
        return blockIn;
    }

    public void setBlockIn(IBlockState blockIn) {
        this.blockIn = blockIn;
    }
}
