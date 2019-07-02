package com.ldtteam.jvoxelizer.launcher.forge_1_12.block.entity;

import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.common.capability.ICapability;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.common.capability.Capability;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.Dimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.item.handling.ItemHandler;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.facing.Facing;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.IItemHandler;

/**
 * Forge implementation of the IBlockEntity interface.
 * Falls back onto TileEntity.
 */
public class BlockEntity implements IBlockEntity, IForgeJVoxelizerWrapper
{
    private final TileEntity forgeTileEntity;

    private BlockEntity(final TileEntity forgeTileEntity) {this.forgeTileEntity = forgeTileEntity;}

    @Override
    public IDimension getDimension()
    {
        return Dimension.fromForge(forgeTileEntity.getWorld());
    }

    @Override
    public IBlockCoordinate getPosition()
    {
        return BlockCoordinate.fromForge(forgeTileEntity.getPos());
    }

    @Override
    public boolean hasCapability(final ICapability<?> capability, final IFacing facing)
    {
        return forgeTileEntity.hasCapability(Capability.asForge(capability), Facing.asForge(facing));
    }

    @Override
    public <T> T getCapability(final ICapability<T> capability, final IFacing facing)
    {
        return capability.convertToJVoxInstanceOrNull(forgeTileEntity.getCapability(Capability.asForge(capability), Facing.asForge(facing)));
    }

    public TileEntity getForgeTileEntity()
    {
        return forgeTileEntity;
    }

    public static TileEntity asForge(IBlockEntity blockEntity)
    {
        if (blockEntity instanceof TileEntity)
        {
            return (TileEntity) blockEntity;
        }

        if (blockEntity == null)
        {
            return null;
        }

        if (!(blockEntity instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("BlockEntity is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) blockEntity).getForgeInstance();
    }

    public static IBlockEntity fromForge(TileEntity tileEntity)
    {
        if (tileEntity instanceof IBlockEntity)
        {
            return (IBlockEntity) tileEntity;
        }

        return new BlockEntity(tileEntity);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeTileEntity();
    }
}
