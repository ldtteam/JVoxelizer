package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.entity.living.ILivingBaseEntity;
import com.ldtteam.jvoxelizer.item.IItemStack;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;

public class OnBlockDestroyedContext {

    public OnBlockDestroyedContext(IItemStack stack, IDimension worldIn, IBlockState state, IBlockCoordinate pos, ILivingBaseEntity entityLiving) {
        this.stack = stack;
        this.worldIn = worldIn;
        this.state = state;
        this.pos = pos;
        this.entityLiving = entityLiving;
    }

    private IItemStack stack;

    public IItemStack getStack() {
        return stack;
    }

    public void setStack(IItemStack stack) {
        this.stack = stack;
    }

    private IDimension worldIn;

    public IDimension getWorldIn() {
        return worldIn;
    }

    public void setWorldIn(IDimension worldIn) {
        this.worldIn = worldIn;
    }

    private IBlockState state;

    public IBlockState getState() {
        return state;
    }

    public void setState(IBlockState state) {
        this.state = state;
    }

    private IBlockCoordinate pos;

    public IBlockCoordinate getPos() {
        return pos;
    }

    public void setPos(IBlockCoordinate pos) {
        this.pos = pos;
    }

    private ILivingBaseEntity entityLiving;

    public ILivingBaseEntity getEntityLiving() {
        return entityLiving;
    }

    public void setEntityLiving(ILivingBaseEntity entityLiving) {
        this.entityLiving = entityLiving;
    }
}
