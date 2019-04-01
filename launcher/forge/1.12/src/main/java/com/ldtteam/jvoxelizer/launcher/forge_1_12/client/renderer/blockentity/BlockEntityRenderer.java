package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.blockentity;

import com.ldtteam.jvoxelizer.client.renderer.blockentity.IBlockEntityRenderer;
import com.ldtteam.jvoxelizer.launcher.forge_1_12.core.IForgeJVoxelizerWrapper;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;

public class BlockEntityRenderer implements IBlockEntityRenderer, IForgeJVoxelizerWrapper
{
    private TileEntityItemStackRenderer forgeBlockRenderer;

    private BlockEntityRenderer(final TileEntityItemStackRenderer forgeBlockRenderer)
    {
        this.forgeBlockRenderer = forgeBlockRenderer;
    }

    public TileEntityItemStackRenderer getForgeBlockRenderer()
    {
        return forgeBlockRenderer;
    }

    public static TileEntityItemStackRenderer asForge(IBlockEntityRenderer blockEntityRenderer)
    {
        if (blockEntityRenderer instanceof TileEntityItemStackRenderer)
            return (TileEntityItemStackRenderer) blockEntityRenderer;

        if (!(blockEntityRenderer instanceof IForgeJVoxelizerWrapper))
            throw new IllegalArgumentException("BlockEntityRenderer is not a wrapper");

        return ((IForgeJVoxelizerWrapper) blockEntityRenderer).getForgeInstance();
    }

    public static IBlockEntityRenderer fromForge(TileEntityItemStackRenderer tileEntitySpecialRenderer)
    {
        if (tileEntitySpecialRenderer instanceof IBlockEntityRenderer)
            return (IBlockEntityRenderer) tileEntitySpecialRenderer;

        return new BlockEntityRenderer(tileEntitySpecialRenderer);
    }

    @Override
    public <T> T getForgeInstance()
    {
        return (T) getForgeBlockRenderer();
    }
}
