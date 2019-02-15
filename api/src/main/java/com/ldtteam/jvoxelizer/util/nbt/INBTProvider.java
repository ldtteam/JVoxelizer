package com.ldtteam.jvoxelizer.util.nbt;

public interface INBTProvider
{

    INBTByte provide(byte value);

    INBTByteArray provide(byte[] value);

    INBTCompound provide();

    INBTList provide(Iterable<INBTBase> values);

    INBTDouble provide(double value);

    INBTFloat provide(float value);

    INBTInteger provide(int value);

    INBTLong provide(long value);

    INBTShort provide(short value);

    INBTString provide(String value);
}
