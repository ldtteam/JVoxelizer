package com.ldtteam.jvoxelizer.client.renderer.opengl.util;

/**
 * The blending factor for the destination when rendering in OpenGL.
 */
public enum DestinationFactor
{
    CONSTANT_ALPHA(32771),
    CONSTANT_COLOR(32769),
    DST_ALPHA(772),
    DST_COLOR(774),
    ONE(1),
    ONE_MINUS_CONSTANT_ALPHA(32772),
    ONE_MINUS_CONSTANT_COLOR(32770),
    ONE_MINUS_DST_ALPHA(773),
    ONE_MINUS_DST_COLOR(775),
    ONE_MINUS_SRC_ALPHA(771),
    ONE_MINUS_SRC_COLOR(769),
    SRC_ALPHA(770),
    SRC_COLOR(768),
    ZERO(0);

    private final int factor;

    DestinationFactor(int factorIn)
    {
        this.factor = factorIn;
    }

    public int getFactor()
    {
        return factor;
    }
}
