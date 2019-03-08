package com.ldtteam.jvoxelizer.client.renderer.tessellator;

/**
 * Provides logic to gain access to tessellators.
 */
public interface ITessellatorProvider
{

    /**
     * Provides the static instance of the Tessellator.
     *
     * @return The static instance of the tessellator.
     */
    ITessellator provideInstance();
}
