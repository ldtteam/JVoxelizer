package com.ldtteam.jvoxelizer.util.tuple;

public interface ITupleProvider
{

    <A, B> ITuple<A, B> provide(A one, B two);
}
