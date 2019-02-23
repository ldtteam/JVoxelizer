package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.raytraceresult;

import com.ldtteam.jvoxelizer.util.math.raytraceresult.IRayTraceResult;

public class RayTraceResult implements IRayTraceResult
{
    private net.minecraft.util.math.RayTraceResult rayTraceResult;

    public RayTraceResult(final net.minecraft.util.math.RayTraceResult rayTraceResult) {
        this.rayTraceResult = rayTraceResult;
    }
}
