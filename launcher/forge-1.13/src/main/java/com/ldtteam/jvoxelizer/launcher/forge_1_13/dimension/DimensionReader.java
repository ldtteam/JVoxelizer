package com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension;

import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.dimension.IDimensionType;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.biome.Biome;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.block.entity.BlockEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.core.IForgeJVoxelizerWrapper;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.facing.Facing;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.IWorldReader;

public class DimensionReader implements IDimensionReader<DummyInstanceData>, IForgeJVoxelizerWrapper
{
    private final IWorldReader forgeBlockAcces;

    protected DimensionReader(final IWorldReader forgeBlockAcces) {this.forgeBlockAcces = forgeBlockAcces;}

    @Override
    public IBlockEntity getBlockEntity(final IBlockCoordinate pos)
    {
        return BlockEntity.fromForge(forgeBlockAcces.getTileEntity(BlockCoordinate.asForge(pos)));
    }

    @Override
    public int getCombinedLight(final IBlockCoordinate pos, final int lightValue)
    {
        return forgeBlockAcces.getCombinedLight(BlockCoordinate.asForge(pos), lightValue);
    }

    @Override
    public IBlockState getBlockState(final IBlockCoordinate pos)
    {
        return BlockState.fromForge(forgeBlockAcces.getBlockState(BlockCoordinate.asForge(pos)));
    }

    @Override
    public boolean isAirBlock(final IBlockCoordinate pos)
    {
        return forgeBlockAcces.isAirBlock(BlockCoordinate.asForge(pos));
    }

    @Override
    public IBiome getBiome(final IBlockCoordinate pos)
    {
        return Biome.fromForge(forgeBlockAcces.getBiome(BlockCoordinate.asForge(pos)));
    }

    @Override
    public int getStrongPower(final IBlockCoordinate pos, final IFacing direction)
    {
        return forgeBlockAcces.getStrongPower(BlockCoordinate.asForge(pos), Facing.asForge(direction));
    }

    @Override
    public IDimensionType getDimensionType()
    {
        return DimensionType.fromForge(forgeBlockAcces.getDimension().getWorld().getWorldType());
    }

    @Override
    public boolean isSideSolid(final IBlockCoordinate pos, final IFacing side, final boolean _default)
    {
        return forgeBlockAcces.getBlockState(BlockCoordinate.asForge(pos)).getBlockFaceShape(forgeBlockAcces, BlockCoordinate.asForge(pos), Facing.asForge(side)) == BlockFaceShape.SOLID;
    }

    @Override
    public DummyInstanceData getInstanceData()
    {
        return new DummyInstanceData();
    }

    private IWorldReader getForgeBlockAcces()
    {
        return forgeBlockAcces;
    }

    public static IWorldReader asForge(IDimensionReader<?> dimensionReader)
    {
        if (dimensionReader instanceof IWorldReader)
        {
            return (IWorldReader) dimensionReader;
        }

        if (dimensionReader == null)
        {
            return null;
        }

        if (!(dimensionReader instanceof IForgeJVoxelizerWrapper))
        {
            throw new IllegalArgumentException("DimensionReader is not a wrapper");
        }

        return ((IForgeJVoxelizerWrapper) dimensionReader).getForgeInstance();
    }

    public static IDimensionReader<?> fromForge(IWorldReader blockAccess)
    {
        if (blockAccess instanceof IDimensionReader)
        {
            return (IDimensionReader<?>) blockAccess;
        }

        return new DimensionReader(blockAccess);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeBlockAcces();
    }
}
