package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.item.IItemStack;

public class CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackContext {

    public CanHarvestBlockWithStateAsIBlockStateAndStackAsItemStackContext(IBlockState state, IItemStack stack) {
        this.state = state;
        this.stack = stack;
    }

    private IBlockState state;

    public IBlockState getState() {
        return state;
    }

    public void setState(IBlockState state) {
        this.state = state;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }
}
