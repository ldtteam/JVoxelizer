package com.ldtteam.jvoxelizer.sound;

import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public interface ISound
{
    IIdentifier getSoundLocation();

    IIdentifier getSoundAsOggLocation();

    float getVolume();

    float getPitch();

    int getWeight();

    ISound cloneEntry();

    ISoundType getType();

    boolean isStreaming();
}
