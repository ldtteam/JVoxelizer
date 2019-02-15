package com.ldtteam.jvoxelizer.util;

public interface ITupleProvider
{

    <A, B> ITuple<A, B> provide(A one, B two);
}
