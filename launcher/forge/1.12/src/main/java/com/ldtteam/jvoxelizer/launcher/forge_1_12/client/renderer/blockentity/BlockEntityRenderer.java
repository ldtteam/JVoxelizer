package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.blockentity;

import com.ldtteam.jvoxelizer.client.renderer.blockentity.IBlockEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;

public class BlockEntityRenderer implements IBlockEntityRenderer
{
    private TileEntityItemStackRenderer forgeBlockRenderer;

    private BlockEntityRenderer(final TileEntityItemStackRenderer forgeBlockRenderer)
    {
        this.forgeBlockRenderer = forgeBlockRenderer;
    }

    public static TileEntityItemStackRenderer asForge(IBlockEntityRenderer blockEntityRenderer)
    {
        if (blockEntityRenderer instanceof TileEntityItemStackRenderer)
            return (TileEntityItemStackRenderer) blockEntityRenderer;

        return ((BlockEntityRenderer) blockEntityRenderer).forgeBlockRenderer;
    }

    public static IBlockEntityRenderer fromForge(TileEntityItemStackRenderer tileEntitySpecialRenderer)
    {
        if (tileEntitySpecialRenderer instanceof IBlockEntityRenderer)
            return (IBlockEntityRenderer) tileEntitySpecialRenderer;

        return new BlockEntityRenderer(tileEntitySpecialRenderer);
    }
}
