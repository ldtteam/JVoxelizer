package com.ldtteam.jvoxelizer.item.logic.builder.contexts;

import com.ldtteam.jvoxelizer.client.renderer.blockentity.IBlockEntityRenderer;

public class SetTileEntityItemStackRendererContext {

    public SetTileEntityItemStackRendererContext(IBlockEntityRenderer teisr) {
        this.teisr = teisr;
    }

    private IBlockEntityRenderer teisr;

    public IBlockEntityRenderer getTeisr() {
        return teisr;
    }

    public void setTeisr(IBlockEntityRenderer teisr) {
        this.teisr = teisr;
    }
}
