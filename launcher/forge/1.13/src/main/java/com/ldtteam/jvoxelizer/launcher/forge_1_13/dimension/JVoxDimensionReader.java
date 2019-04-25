package com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension;

import com.ldtteam.jvoxelizer.biome.IBiome;
import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.core.logic.PipelineProcessor;
import com.ldtteam.jvoxelizer.dimension.IDimensionReader;
import com.ldtteam.jvoxelizer.dimension.IDimensionType;
import com.ldtteam.jvoxelizer.dimension.logic.builder.contexts.*;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.block.entity.BlockEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.dimension.logic.pipeline.DimensionReaderBuilderPipeline;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.facing.Facing;
import com.ldtteam.jvoxelizer.launcher.forge_1_13.util.math.coordinate.block.BlockCoordinate;
import com.ldtteam.jvoxelizer.util.facing.IFacing;
import com.ldtteam.jvoxelizer.util.math.coordinate.block.IBlockCoordinate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.fluid.IFluidState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.EnumLightType;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.gen.Heightmap;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class JVoxDimensionReader<I> implements IWorldReader, IDimensionReader<I>
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

    @Override
    public IFluidState getFluidState(final BlockPos pos)
    {
        return null;
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
        return com.ldtteam.jvoxelizer.launcher.forge_1_13.biome.Biome.asForge(this.getBiome(BlockCoordinate.fromForge(pos)));
    }

    @Override
    public int getLightFor(final EnumLightType type, final BlockPos pos)
    {
        return 0;
    }

    @Override
    public int getLightSubtracted(final BlockPos pos, final int amount)
    {
        return 0;
    }

    @Override
    public boolean isChunkLoaded(final int x, final int z, final boolean allowEmpty)
    {
        return false;
    }

    @Override
    public boolean canSeeSky(final BlockPos pos)
    {
        return false;
    }

    @Override
    public int getHeight(final Heightmap.Type heightmapType, final int x, final int z)
    {
        return 0;
    }

    @Nullable
    @Override
    public EntityPlayer getClosestPlayer(final double x, final double y, final double z, final double distance, final Predicate<Entity> predicate)
    {
        return null;
    }

    @Override
    public int getSkylightSubtracted()
    {
        return 0;
    }

    @Override
    public WorldBorder getWorldBorder()
    {
        return null;
    }

    @Override
    public boolean checkNoEntityCollision(@Nullable final Entity entityIn, final VoxelShape shape)
    {
        return false;
    }

    @Override
    public int getStrongPower(final BlockPos pos, final EnumFacing direction)
    {
        return this.getStrongPower(BlockCoordinate.fromForge(pos), Facing.fromForge(direction));
    }

    @Override
    public boolean isRemote()
    {
        return false;
    }

    @Override
    public int getSeaLevel()
    {
        return 0;
    }

    @Override
    public Dimension getDimension()
    {
        return null;
    }
}
