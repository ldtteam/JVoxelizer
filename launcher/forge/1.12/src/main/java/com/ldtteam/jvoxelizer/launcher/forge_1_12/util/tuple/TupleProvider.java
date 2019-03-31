package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.tuple;

import com.ldtteam.jvoxelizer.util.tuple.ITuple;
import com.ldtteam.jvoxelizer.util.tuple.ITupleProvider;

public class TupleProvider implements ITupleProvider
{
    private static TupleProvider ourInstance = new TupleProvider();

    public static TupleProvider getInstance()
    {
        return ourInstance;
    }

    private TupleProvider()
    {
    }

    @Override
    public <A, B> ITuple<A, B> provide(final A one, final B two)
    {
        return Tuple.fromForge(new net.minecraft.util.Tuple(one, two));
    }
}
