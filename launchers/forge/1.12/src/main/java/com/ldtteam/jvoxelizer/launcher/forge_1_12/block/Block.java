package com.ldtteam.jvoxelizer.launcher.forge_1_12.block;

import com.ldtteam.jvoxelizer.block.IBlock;

public class Block implements IBlock
{

    private net.minecraft.block.Block forgeBlock;

    public Block(final net.minecraft.block.Block forgeBlock)
    {
        this.forgeBlock = forgeBlock;
    }
}
