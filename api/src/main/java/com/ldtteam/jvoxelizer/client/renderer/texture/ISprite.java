package com.ldtteam.jvoxelizer.client.renderer.texture;

public interface ISprite
{
    float getMinU();

    float getInterpolatedV(double h);

    float getInterpolatedU(double w);

    float getMaxU();

    float getMaxV();

    float getMinV();
}
