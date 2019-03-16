package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math;

public final class MathHelper
{
    private MathHelper()
    {
        throw new IllegalStateException("Tried to initialize: MathHelper but this is a Utility class.");
    }

    /**
     * Clamps the value given between min and max.
     *
     * @return the value of the first parameter, clamped to be within the lower and upper limits given by the second and
     * third parameters.
     */
    public static int clamp(int num, int min, int max)
    {
        if (num < min)
        {
            return min;
        }
        else
        {
            return num > max ? max : num;
        }
    }
}
