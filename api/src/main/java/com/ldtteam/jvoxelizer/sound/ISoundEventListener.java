package com.ldtteam.jvoxelizer.sound;

public interface ISoundEventListener
{
    void soundPlay(ISound soundIn, ISoundEventAccessor<?> accessor);
}
