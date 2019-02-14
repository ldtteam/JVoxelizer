package com.ldtteam.minelaunch.util;

public interface ITupleProvider
{

    <A, B> ITuple<A, B> provide(A one, B two);
}
