package com.ldtteam.jvoxelizer.launcher.forge_1_12.block.entity;

import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.Dimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import net.minecraft.tileentity.TileEntity;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BlockEntity implements IBlockEntity
{
    private final TileEntity forgeTileEntity;

    public BlockEntity(final TileEntity forgeTileEntity) {this.forgeTileEntity = forgeTileEntity;}

    @Override
    public IDimension getDimension()
    {
        return new Dimension(forgeTileEntity.getWorld());
    }

    @Override
    public IBlockCoordinate getPosition()
    {
        return new BlockCoordinate(forgeTileEntity.getPos());
    }

    @Override
    public boolean hasCapability(final ICapability<?> capability, final IFacing facing)
    {
        //TODO: Capability implementation.
        throw new NotImplementedException();
    }

    @Override
    public <T> T getCapability(final ICapability<T> capability, final IFacing facing)
    {
        //TODO: Capability implementation;
        throw new NotImplementedException();
    }
}
