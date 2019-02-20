package com.ldtteam.jvoxelizer.client.renderer.tessellator;

import com.ldtteam.jvoxelizer.client.renderer.bufferbuilder.IBufferBuilder;

public interface ITessellator
{

    static ITessellator getInstance()
    {
        return ITessellatorProviderHolder.getInstance().provideInstance();
    }

    IBufferBuilder getBuffer();

    void draw();
}
