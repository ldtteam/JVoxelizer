package com.ldtteam.jvoxelizer.client.renderer.opengl.util;

public enum FogMode
{
    LINEAR(9729),
    EXP(2048),
    EXP2(2049);

    private final int capabilityId;

    FogMode(int capabilityIn)
    {
        this.capabilityId = capabilityIn;
    }

    public int getCapabilityId()
    {
        return capabilityId;
    }
}
