package com.ldtteam.jvoxelizer.launcher.forge_1_12.client.renderer.blockentity;

import com.ldtteam.jvoxelizer.client.renderer.blockentity.IBlockEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;

public class BlockEntityRenderer implements IBlockEntityRenderer
{
    private TileEntityItemStackRenderer stackRenderer;

    public BlockEntityRenderer(final TileEntityItemStackRenderer stackRenderer)
    {
        this.stackRenderer = stackRenderer;
    }

    /**
     * Get the wrapped forge class.
     * @return TileEntityItemStackRenderer.
     */
    public TileEntityItemStackRenderer getForgeRenderer()
    {
        return this.stackRenderer;
    }
}
