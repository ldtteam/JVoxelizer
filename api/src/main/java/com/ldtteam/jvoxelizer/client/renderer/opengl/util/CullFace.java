package com.ldtteam.jvoxelizer.client.renderer.opengl.util;

public enum CullFace
{
    FRONT(1028),
    BACK(1029),
    FRONT_AND_BACK(1032);

    private final int mode;

    CullFace(int modeIn)
    {
        this.mode = modeIn;
    }

    public int getMode()
    {
        return mode;
    }
}