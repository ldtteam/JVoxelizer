package com.ldtteam.jvoxelizer.client.renderer.texture;

public interface ISprite
{
    int getMinU();

    int getInterpolatedV(int h);

    int getInterpolatedU(int w);

    int getMaxU();

    int getMaxV();

    int getMinV();
}
