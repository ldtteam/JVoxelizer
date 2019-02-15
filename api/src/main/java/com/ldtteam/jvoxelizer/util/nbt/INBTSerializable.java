package com.ldtteam.jvoxelizer.util.nbt;

public interface INBTSerializable
{

    INBTCompound write();

    void read(INBTCompound data);
}
