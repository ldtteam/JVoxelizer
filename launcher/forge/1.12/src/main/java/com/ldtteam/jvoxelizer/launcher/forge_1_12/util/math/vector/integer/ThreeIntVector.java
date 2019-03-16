package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.vector.integer;

import com.ldtteam.jvoxelizer.util.math.vector.integer.I3IntVector;
import net.minecraft.util.math.Vec3i;

public class ThreeIntVector implements I3IntVector
{
    private Vec3i vec3i;

    private ThreeIntVector(final Vec3i vec3i)
    {
        this.vec3i = vec3i;
    }

    @Override
    public int getX()
    {
        return vec3i.getX();
    }

    @Override
    public int getY()
    {
        return vec3i.getY();
    }

    @Override
    public int getZ()
    {
        return vec3i.getZ();
    }

    public static Vec3i asForge(I3IntVector vec)
    {
        if (vec instanceof Vec3i)
            return (Vec3i) vec;

        return ((ThreeIntVector) vec).vec3i;
    }

    public static I3IntVector fromForge(Vec3i vec)
    {
        if (vec instanceof I3IntVector)
            return (I3IntVector) vec;

        return new ThreeIntVector(vec);
    }
}
