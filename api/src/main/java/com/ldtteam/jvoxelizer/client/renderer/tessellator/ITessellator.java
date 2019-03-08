package com.ldtteam.jvoxelizer.client.renderer.tessellator;

import com.ldtteam.jvoxelizer.client.renderer.bufferbuilder.IBufferBuilder;

/**
 * The vertex handler that handles drawing of the vertexes in its buffer.
 */
public interface ITessellator
{

    /**
     * The instance of the tessellator.
     * @return
     */
    static ITessellator getInstance()
    {
        return ITessellatorProviderHolder.getInstance().provideInstance();
    }

    /**
     * The buffer of the tessellator that it draws from.
     *
     * @return The buffer builder that controls the tessellators buffer.
     */
    IBufferBuilder getBuffer();

    /**
     * Draws the current buffer and clears it.
     */
    void draw();
}
