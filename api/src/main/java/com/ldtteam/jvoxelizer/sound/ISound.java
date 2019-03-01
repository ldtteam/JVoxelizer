package com.ldtteam.jvoxelizer.sound;

import com.ldtteam.jvoxelizer.util.identifier.IIdentifier;

public interface ISound
{
    IIdentifier getSoundLocation();

    float getVolume();

    float getPitch();

    ISound cloneEntry();
}
