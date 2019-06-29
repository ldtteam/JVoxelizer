package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.math.vector.floatingpoint;

import com.ldtteam.jvoxelizer.util.math.vector.floatingpoint.I3DoubleVector;
import com.ldtteam.jvoxelizer.util.math.vector.floatingpoint.I3DoubleVectorProvider;
import net.minecraft.util.math.Vec3d;

public class ThreeDoubleVectorProvider implements I3DoubleVectorProvider
{
    private static ThreeDoubleVectorProvider ourInstance = new ThreeDoubleVectorProvider();

    public static ThreeDoubleVectorProvider getInstance()
    {
        return ourInstance;
    }

    private ThreeDoubleVectorProvider()
    {
    }

    @Override
    public I3DoubleVector provide(final double x, final double y, final double z)
    {
        return ThreeDoubleVector.fromForge(new Vec3d(x,y,z));
    }
}
