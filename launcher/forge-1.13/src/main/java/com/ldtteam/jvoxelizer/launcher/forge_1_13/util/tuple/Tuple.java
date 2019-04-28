package com.ldtteam.jvoxelizer.launcher.forge_1_13.util.tuple;

import com.ldtteam.jvoxelizer.util.tuple.ITuple;

import java.util.Objects;

public class Tuple<A, B> implements ITuple<A, B>
{
    private net.minecraft.util.Tuple<A, B> tuple;

    private Tuple(final net.minecraft.util.Tuple<A, B> tuple)
    {
        this.tuple = tuple;
    }

    @Override
    public A getFirst()
    {
        return tuple.getA();
    }

    @Override
    public B getSecond()
    {
        return tuple.getB();
    }

    public static <A, B> net.minecraft.util.Tuple<A, B> asForge(final ITuple tuple)
    {
        if (tuple instanceof net.minecraft.util.Tuple)
        {
            return (net.minecraft.util.Tuple<A, B>) tuple;
        }

        return ((Tuple<A, B>) tuple).tuple;
    }

    public static<A, B> ITuple<A, B> fromForge(final net.minecraft.util.Tuple tuple)
    {
        if (tuple instanceof ITuple)
        {
            return (ITuple<A, B>) tuple;
        }

        return new Tuple<A, B>(tuple);
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
