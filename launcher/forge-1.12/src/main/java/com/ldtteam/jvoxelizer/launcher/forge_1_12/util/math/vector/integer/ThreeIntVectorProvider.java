package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.math.vector.integer;

import com.ldtteam.jvoxelizer.util.math.vector.integer.I3IntVector;
import com.ldtteam.jvoxelizer.util.math.vector.integer.I3IntVectorProvider;
import net.minecraft.util.math.Vec3i;

public class ThreeIntVectorProvider implements I3IntVectorProvider
{
    private static ThreeIntVectorProvider ourInstance = new ThreeIntVectorProvider();

    public static ThreeIntVectorProvider getInstance()
    {
        return ourInstance;
    }

    private ThreeIntVectorProvider()
    {
    }

    @Override
    public I3IntVector provide(final int x, final int y, final int z)
    {
        return ThreeIntVector.fromForge(new Vec3i(x,y,z));
    }
}
