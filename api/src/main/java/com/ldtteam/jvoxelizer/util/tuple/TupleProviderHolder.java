package com.ldtteam.jvoxelizer.util.tuple;

import com.ldtteam.jvoxelizer.core.provider.holder.AbstractHolder;

final class TupleProviderHolder extends AbstractHolder<ITupleProvider> implements ITupleProvider
{
    private static TupleProviderHolder ourInstance = new TupleProviderHolder();

    public static TupleProviderHolder getInstance()
    {
        return ourInstance;
    }

    private TupleProviderHolder()
    {
        super(ITuple.class.getName());
    }

    @Override
    public <A, B> ITuple<A, B> provide(final A one, final B two)
    {
        return getProvider().provide(one, two);
    }
}
