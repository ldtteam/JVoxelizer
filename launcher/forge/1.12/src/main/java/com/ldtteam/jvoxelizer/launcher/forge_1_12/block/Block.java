package com.ldtteam.jvoxelizer.launcher.forge_1_12.block;

import com.ldtteam.jvoxelizer.block.IBlock;
import com.ldtteam.jvoxelizer.block.entity.IBlockEntity;
import com.ldtteam.jvoxelizer.block.state.IBlockState;
import com.ldtteam.jvoxelizer.dimension.IDimension;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.entity.BlockEntity;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.block.state.BlockState;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.dimension.Dimension;
import net.minecraft.block.BlockAir;

public class Block implements IBlock
{

    private net.minecraft.block.Block forgeBlock;

    public Block(final net.minecraft.block.Block forgeBlock)
    {
        this.forgeBlock = forgeBlock;
    }

    @Override
    public boolean isAir()
    {
        return forgeBlock instanceof BlockAir;
    }

    @Override
    public IBlockEntity createBlockEntity(
      final IDimension dimension, final IBlockState state)
    {
        return new BlockEntity(forgeBlock.createTileEntity(((Dimension) dimension).getForgeWorld(), ((BlockState) state).getForgeBlockState()));
    }
}
