package com.ldtteam.minelaunch.util.nbt;

public interface INBTSerializable
{

    INBTCompound write();

    void read(INBTCompound data);
}
