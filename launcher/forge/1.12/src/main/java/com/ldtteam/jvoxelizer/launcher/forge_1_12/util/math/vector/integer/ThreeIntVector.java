package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.vector.integer;

import com.ldtteam.jvoxelizer.util.math.vector.integer.I3IntVector;
import net.minecraft.util.math.Vec3i;

public class ThreeIntVector implements I3IntVector
{
    private Vec3i vec3i;

    public ThreeIntVector(final Vec3i vec3i)
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
}
