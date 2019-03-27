package com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension;

import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.core.logic.DummyInstanceData;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.dimension.IDimensionType;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.biome.Biome;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.entity.BlockEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.facing.Facing;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import net.minecraft.world.IBlockAccess;

public class DimensionReader implements IDimensionReader<DummyInstanceData>
{
    private final IBlockAccess forgeBlockAcces;

    protected DimensionReader(final IBlockAccess forgeBlockAcces) {this.forgeBlockAcces = forgeBlockAcces;}

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
        return DimensionType.fromForge(forgeBlockAcces.getWorldType());
    }

    @Override
    public boolean isSideSolid(final IBlockCoordinate pos, final IFacing side, final boolean _default)
    {
        return forgeBlockAcces.isSideSolid(BlockCoordinate.asForge(pos), Facing.asForge(side), _default);
    }

    @Override
    public DummyInstanceData getInstanceData()
    {
        return new DummyInstanceData();
    }

    private IBlockAccess getForgeBlockAcces()
    {
        return forgeBlockAcces;
    }

    public static IBlockAccess asForge(IDimensionReader<?> dimensionReader)
    {
        if (dimensionReader instanceof IBlockAccess)
            return (IBlockAccess) dimensionReader;

        return ((DimensionReader) dimensionReader).getForgeBlockAcces();
    }

    public static IDimensionReader<?> fromForge(IBlockAccess blockAccess)
    {
        if (blockAccess instanceof IDimensionReader)
            return (IDimensionReader<?>) blockAccess;

        return new DimensionReader(blockAccess);
    }
}
