package com.ldtteam.jvoxelizer.launcher.forge_1_13.sound;

import com.ldtteam.jvoxelizer.sound.ISoundEventListener;

public class SoundEventListener implements ISoundEventListener
{
    private final net.minecraft.client.audio.ISoundEventListener forgeSoundEventListener;

    private SoundEventListener(final net.minecraft.client.audio.ISoundEventListener forgeSoundEventListener) {this.forgeSoundEventListener = forgeSoundEventListener;}

    public static net.minecraft.client.audio.ISoundEventListener asForge(final ISoundEventListener listener)
    {
        if (listener instanceof net.minecraft.client.audio.ISoundEventListener)
        {
            return (net.minecraft.client.audio.ISoundEventListener) listener;
        }

        return ((SoundEventListener) listener).forgeSoundEventListener;
    }

    public static ISoundEventListener fromForge(final net.minecraft.client.audio.ISoundEventListener listener)
    {
        if (listener instanceof ISoundEventListener)
        {
            return (ISoundEventListener) listener;
        }

        return new SoundEventListener(listener);
    }
}
