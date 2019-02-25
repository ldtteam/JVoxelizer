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

public class DimensionReader<I> implements IDimensionReader<I>
{
    private final IBlockAccess forgeBlockAcces;

    public DimensionReader(final IBlockAccess forgeBlockAcces) {this.forgeBlockAcces = forgeBlockAcces;}

    @Override
    public IBlockEntity getBlockEntity(final IBlockCoordinate pos)
    {
        return new BlockEntity(forgeBlockAcces.getTileEntity(((BlockCoordinate) pos).getForgeBlockPos()));
    }

    @Override
    public int getCombinedLight(final IBlockCoordinate pos, final int lightValue)
    {
        return forgeBlockAcces.getCombinedLight(((BlockCoordinate) pos).getForgeBlockPos(), lightValue);
    }

    @Override
    public IBlockState getBlockState(final IBlockCoordinate pos)
    {
        return new BlockState(forgeBlockAcces.getBlockState(((BlockCoordinate) pos).getForgeBlockPos()));
    }

    @Override
    public boolean isAirBlock(final IBlockCoordinate pos)
    {
        return forgeBlockAcces.isAirBlock(((BlockCoordinate) pos).getForgeBlockPos());
    }

    @Override
    public IBiome getBiome(final IBlockCoordinate pos)
    {
        return new Biome(forgeBlockAcces.getBiome(((BlockCoordinate) pos).getForgeBlockPos()));
    }

    @Override
    public int getStrongPower(final IBlockCoordinate pos, final IFacing direction)
    {
        return forgeBlockAcces.getStrongPower(((BlockCoordinate) pos).getForgeBlockPos(), ((Facing) direction).getForgeSide());
    }

    @Override
    public IDimensionType getWorldType()
    {
        return new DimensionType(forgeBlockAcces.getWorldType());
    }

    @Override
    public boolean isSideSolid(final IBlockCoordinate pos, final IFacing side, final boolean _default)
    {
        return forgeBlockAcces.isSideSolid(((BlockCoordinate) pos).getForgeBlockPos(), ((Facing) side).getForgeSide(), _default);
    }

    @Override
    public I getInstanceData()
    {
        return (I) (forgeBlockAcces instanceof IDimensionReader ? ((IDimensionReader<?>) forgeBlockAcces).getInstanceData() : new DummyInstanceData());
    }

    public IBlockAccess getForgeBlockAcces()
    {
        return forgeBlockAcces;
    }
}
