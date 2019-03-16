package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.raytraceresult;

import com.ldtteam.jvoxelizer.util.math.raytraceresult.IRayTraceResult;

public class RayTraceResult implements IRayTraceResult
{
    private net.minecraft.util.math.RayTraceResult rayTraceResult;

    private RayTraceResult(final net.minecraft.util.math.RayTraceResult rayTraceResult) {
        this.rayTraceResult = rayTraceResult;
    }

    public static net.minecraft.util.math.RayTraceResult asForge(IRayTraceResult distribution)
    {
        return ((RayTraceResult) distribution).rayTraceResult;
    }

    public static IRayTraceResult fromForge(net.minecraft.util.math.RayTraceResult side)
    {
        return new RayTraceResult(side);
    }
}
