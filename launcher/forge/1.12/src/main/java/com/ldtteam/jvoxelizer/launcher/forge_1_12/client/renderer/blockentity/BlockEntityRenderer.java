package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.blockentity;

import com.ldtteam.jvoxelizer.client.renderer.blockentity.IBlockEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class BlockEntityRenderer implements IBlockEntityRenderer
{
    private TileEntitySpecialRenderer forgeBlockRenderer;

    private BlockEntityRenderer(final TileEntitySpecialRenderer forgeBlockRenderer)
    {
        this.forgeBlockRenderer = forgeBlockRenderer;
    }

    public TileEntitySpecialRenderer getForgeBlockRenderer()
    {
        return forgeBlockRenderer;
    }

    public static TileEntitySpecialRenderer<?> asForge(IBlockEntityRenderer blockEntityRenderer)
    {
        if (blockEntityRenderer instanceof TileEntitySpecialRenderer)
            return (TileEntitySpecialRenderer<?>) blockEntityRenderer;

        return ((BlockEntityRenderer) blockEntityRenderer).getForgeBlockRenderer();
    }

    public static IBlockEntityRenderer fromForge(TileEntitySpecialRenderer<?> tileEntitySpecialRenderer)
    {
        if (tileEntitySpecialRenderer instanceof IBlockEntityRenderer)
            return (IBlockEntityRenderer) tileEntitySpecialRenderer;

        return new BlockEntityRenderer(tileEntitySpecialRenderer);
    }
}
