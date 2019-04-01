package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.vector.floatingpoint;

import com.ldtteam.jvoxelizer.util.math.vector.floatingpoint.I3DoubleVector;
import net.minecraft.util.math.Vec3d;

public class ThreeDoubleVector implements I3DoubleVector
{
    private Vec3d vec3d;

    private ThreeDoubleVector(final Vec3d vec3d)
    {
        this.vec3d = vec3d;
    }

    @Override
    public double getX()
    {
        return vec3d.x;
    }

    @Override
    public double getY()
    {
        return vec3d.y;
    }

    @Override
    public double getZ()
    {
        return vec3d.z;
    }

    public static Vec3d asForge(I3DoubleVector vec)
    {
        if (vec instanceof Vec3d)
        {
            return (Vec3d) vec;
        }

        return ((ThreeDoubleVector) vec).vec3d;
    }

    public static I3DoubleVector fromForge(Vec3d vec)
    {
        if (vec instanceof I3DoubleVector)
        {
            return (I3DoubleVector) vec;
        }

        return new ThreeDoubleVector(vec);
    }
}
