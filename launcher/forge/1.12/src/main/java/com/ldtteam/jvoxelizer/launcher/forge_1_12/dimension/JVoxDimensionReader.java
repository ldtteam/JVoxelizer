package com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension;

import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.core.logic.PipelineProcessor;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.dimension.IDimensionType;
import com.ldtteam.jvoxelizer.dimension.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.entity.BlockEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.logic.pipeline.DimensionReaderBuilderPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.facing.Facing;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;

public class JVoxDimensionReader<I> implements IBlockAccess, IDimensionReader<I>
{
    private final DimensionReaderBuilderPipeline<IDimensionReader<I>, I> pipeline;
    private final I                                                      instanceData;

    public JVoxDimensionReader(final DimensionReaderBuilderPipeline<IDimensionReader<I>, I> pipeline, final I instanceData)
    {
        this.pipeline = pipeline;
        this.instanceData = instanceData;
    }

    @Override
    public IBlockEntity getBlockEntity(final IBlockCoordinate pos)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetBlockEntityContext(pos),
          pipeline.getGetBlockEntityPipeline(),
          (c) -> {
              throw new IllegalStateException("Interface method");
          }
        );
    }

    @Override
    public int getCombinedLight(final IBlockCoordinate pos, final int lightValue)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetCombinedLightContext(pos, lightValue),
          pipeline.getGetCombinedLightPipeline(),
          (c) -> {
              throw new IllegalStateException("Interface method");
          }
        );
    }

    @Override
    public IBlockState getBlockState(final IBlockCoordinate pos)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetBlockStateContext(pos),
          pipeline.getGetBlockStatePipeline(),
          (c) -> {
              throw new IllegalStateException("Interface method");
          }
        );
    }

    @Override
    public boolean isAirBlock(final IBlockCoordinate pos)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsAirBlockContext(pos),
          pipeline.getIsAirBlockPipeline(),
          (c) -> {
              throw new IllegalStateException("Interface method");
          }
        );
    }

    @Override
    public IBiome getBiome(final IBlockCoordinate pos)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetBiomeContext(pos),
          pipeline.getGetBiomePipeline(),
          (c) -> {
              throw new IllegalStateException("Interface method");
          }
        );
    }

    @Override
    public IDimensionType getDimensionType()
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetWorldTypeContext(),
          pipeline.getGetWorldTypePipeline(),
          (c) -> {
              throw new IllegalStateException("Interface method");
          }
        );
    }

    @Override
    public int getStrongPower(final IBlockCoordinate pos, final IFacing direction)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new GetStrongPowerContext(pos, direction),
          pipeline.getGetStrongPowerPipeline(),
          (c) -> {
              throw new IllegalStateException("Interface method");
          }
        );
    }

    @Override
    public boolean isSideSolid(final IBlockCoordinate pos, final IFacing side, final boolean _default)
    {
        return PipelineProcessor.processTypedPipeline(
          this,
          new IsSideSolidContext(pos, side, _default),
          pipeline.getIsSideSolidPipeline(),
          (c) -> {
              throw new IllegalStateException("Interface method");
          }
        );
    }

    @Override
    public I getInstanceData()
    {
        return instanceData;
    }

    @Nullable
    @Override
    public TileEntity getTileEntity(final BlockPos pos)
    {
        return BlockEntity.asForge(this.getBlockEntity(BlockCoordinate.fromForge(pos)));
    }

    @Override
    public int getCombinedLight(final BlockPos pos, final int lightValue)
    {
        return this.getCombinedLight(BlockCoordinate.fromForge(pos), lightValue);
    }

    @Override
    public net.minecraft.block.state.IBlockState getBlockState(final BlockPos pos)
    {
        return BlockState.asForge(this.getBlockState(BlockCoordinate.fromForge(pos)));
    }

    /**
     * Checks to see if an air block exists at the provided location. Note that this only checks to see if the blocks
     * material is set to air, meaning it is possible for non-vanilla blocks to still pass this check.
     */
    @Override
    public boolean isAirBlock(final BlockPos pos)
    {
        return this.isAirBlock(BlockCoordinate.fromForge(pos));
    }

    @Override
    public Biome getBiome(final BlockPos pos)
    {
        return com.ldtteam.jvoxelizer.launcher.forge_1_12.biome.Biome.asForge(this.getBiome(BlockCoordinate.fromForge(pos)));
    }

    @Override
    public int getStrongPower(final BlockPos pos, final EnumFacing direction)
    {
        return this.getStrongPower(BlockCoordinate.fromForge(pos), Facing.fromForge(direction));
    }

    @Override
    public WorldType getWorldType()
    {
        return DimensionType.asForge(this.getDimensionType());
    }

    @Override
    public boolean isSideSolid(final BlockPos pos, final EnumFacing side, final boolean _default)
    {
        return this.isSideSolid(BlockCoordinate.fromForge(pos), Facing.fromForge(side), _default);
    }
}
