package com.ldtteam.jvoxelizer.util.math.vector.floatingpoint;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class I3DoubleVectorProviderHolder extends AbstractHolder<I3DoubleVectorProvider> implements I3DoubleVectorProvider
{
    private static I3DoubleVectorProviderHolder
      ourInstance = new I3DoubleVectorProviderHolder();

    public static I3DoubleVectorProviderHolder getInstance()
    {
        return ourInstance;
    }

    private I3DoubleVectorProviderHolder()
    {
        super(I3DoubleVector.class.getName());
    }

    @Override
    public I3DoubleVector provide(final double x, final double y, final double z)
    {
        return getProvider().provide(x, y, z);
    }
}
