package com.ldtteam.jvoxelizer.util.math.vector.integer;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class I3IntVectorProviderHolder extends AbstractHolder<I3IntVectorProvider> implements I3IntVectorProvider
{
    private static I3IntVectorProviderHolder ourInstance = new I3IntVectorProviderHolder();

    public static I3IntVectorProviderHolder getInstance()
    {
        return ourInstance;
    }

    private I3IntVectorProviderHolder()
    {
        super(I3IntVector.class.getName());
    }

    @Override
    public I3IntVector provide(final int x, final int y, final int z)
    {
        return getProvider().provide(x, y, z);
    }
}
