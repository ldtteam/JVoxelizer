package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.tuple;

import com.ldtteam.jvoxelizer.util.tuple.ITuple;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Tuple))
        {
            return false;
        }

        final Tuple<?, ?> tuple1 = (Tuple<?, ?>) o;

        return Objects.equals(tuple, tuple1.tuple);
    }

    @Override
    public int hashCode()
    {
        return tuple != null ? tuple.hashCode() : 0;
    }
}
