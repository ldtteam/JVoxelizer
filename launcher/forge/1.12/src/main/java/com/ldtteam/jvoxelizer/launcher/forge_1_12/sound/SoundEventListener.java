package com.ldtteam.jvoxelizer.launcher.forge_1_12.sound;

import com.ldtteam.jvoxelizer.sound.ISound;
import com.ldtteam.jvoxelizer.sound.ISoundEventAccessor;
import com.ldtteam.jvoxelizer.sound.ISoundEventListener;

public class SoundEventListener implements ISoundEventListener
{
    private final net.minecraft.client.audio.ISoundEventListener forgeSoundEventListener;

    public SoundEventListener(final net.minecraft.client.audio.ISoundEventListener forgeSoundEventListener) {this.forgeSoundEventListener = forgeSoundEventListener;}

    public net.minecraft.client.audio.ISoundEventListener getForgeSoundEventListener()
    {
        return forgeSoundEventListener;
    }

    public static net.minecraft.client.audio.ISoundEventListener asForge(ISoundEventListener soundEventListener)
    {
        return ((SoundEventListener) soundEventListener).getForgeSoundEventListener();
    }
}
