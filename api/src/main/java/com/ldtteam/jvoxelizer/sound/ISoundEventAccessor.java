package com.ldtteam.jvoxelizer.sound;

public interface ISoundEventAccessor<T>
{
    int getWeight();

    T cloneEntry();
}
