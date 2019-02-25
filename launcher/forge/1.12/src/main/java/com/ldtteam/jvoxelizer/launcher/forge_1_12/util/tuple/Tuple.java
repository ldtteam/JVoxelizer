package com.ldtteam.jvoxelizer.launcher.forge_1_12.util.tuple;

import com.ldtteam.jvoxelizer.util.tuple.ITuple;

public class Tuple<A, B> implements ITuple
{
    private net.minecraft.util.Tuple tuple;

    public Tuple(final net.minecraft.util.Tuple tuple)
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
}