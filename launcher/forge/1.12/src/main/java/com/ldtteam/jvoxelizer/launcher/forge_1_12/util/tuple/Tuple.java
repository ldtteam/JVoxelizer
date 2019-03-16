package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.tuple;

import com.ldtteam.jvoxelizer.util.tuple.ITuple;

public class Tuple<A, B> implements ITuple
{
    private net.minecraft.util.Tuple tuple;

    private Tuple(final net.minecraft.util.Tuple tuple)
    {
        this.tuple = tuple;
    }

    @Override
    public Object getFirst()
    {
        return tuple.getFirst();
    }

    @Override
    public Object getSecond()
    {
        return tuple.getSecond();
    }

    public static net.minecraft.util.Tuple asForge(final ITuple tuple)
    {
        if (tuple instanceof net.minecraft.util.Tuple)
            return (net.minecraft.util.Tuple) tuple;

        return ((Tuple) tuple).tuple;
    }

    public static ITuple fromForge(final net.minecraft.util.Tuple tuple)
    {
        if (tuple instanceof ITuple)
            return (ITuple) tuple;

        return new Tuple(tuple);
    }
}
