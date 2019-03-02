package com.ldtteam.jvoxelizer.launcher.forge_1_12.sound;

import com.ldtteam.jvoxelizer.sound.ISoundEventAccessor;

public class SoundEventAccessor implements ISoundEventAccessor<Sound>
{
    private final net.minecraft.client.audio.SoundEventAccessor forgeSourceEventAccessor;

    public SoundEventAccessor(final net.minecraft.client.audio.SoundEventAccessor forgeSourceEventAccessor) {this.forgeSourceEventAccessor = forgeSourceEventAccessor;}

    @Override
    public int getWeight()
    {
        return forgeSourceEventAccessor.getWeight();
    }

    @Override
    public Sound cloneEntry()
    {
        return new Sound(forgeSourceEventAccessor.cloneEntry());
    }
}
