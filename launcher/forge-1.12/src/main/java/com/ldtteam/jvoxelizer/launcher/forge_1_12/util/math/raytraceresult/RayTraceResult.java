package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.raytraceresult;

import com.ldtteam.jvoxelizer.util.math.raytraceresult.IRayTraceResult;

public class RayTraceResult implements IRayTraceResult
{
    private net.minecraft.util.math.RayTraceResult rayTraceResult;

    private RayTraceResult(final net.minecraft.util.math.RayTraceResult rayTraceResult)
    {
        this.rayTraceResult = rayTraceResult;
    }

    public static net.minecraft.util.math.RayTraceResult asForge(IRayTraceResult result)
    {
        if (result instanceof net.minecraft.util.math.RayTraceResult)
        {
            return (net.minecraft.util.math.RayTraceResult) result;
        }

        return ((RayTraceResult) result).rayTraceResult;
    }

    public static IRayTraceResult fromForge(net.minecraft.util.math.RayTraceResult result)
    {
        if (result instanceof IRayTraceResult)
        {
            return (IRayTraceResult) result;
        }

        return new RayTraceResult(result);
    }
}
