package com.ldtteam.jvoxelizer.util.nbt;

public interface INBTByteArray extends INBTBase
{

    byte[] getValue();

    void setValue(byte[] value);
}
