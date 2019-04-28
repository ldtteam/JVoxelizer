package com.ldtteam.jvoxelizer.launcher.forge_1_12.sound;

import com.ldtteam.jvoxelizer.sound.ISoundEventAccessor;

public class SoundEventAccessor implements ISoundEventAccessor<Sound>
{
    private final net.minecraft.client.audio.SoundEventAccessor forgeSourceEventAccessor;

    private SoundEventAccessor(final net.minecraft.client.audio.SoundEventAccessor forgeSourceEventAccessor) {this.forgeSourceEventAccessor = forgeSourceEventAccessor;}

    @Override
    public int getWeight()
    {
        return forgeSourceEventAccessor.getWeight();
    }

    public static net.minecraft.client.audio.SoundEventAccessor asForge(final ISoundEventAccessor accessor)
    {
        if (accessor instanceof net.minecraft.client.audio.SoundEventAccessor)
        {
            return (net.minecraft.client.audio.SoundEventAccessor) accessor;
        }

        return ((SoundEventAccessor) accessor).forgeSourceEventAccessor;
    }

    public static ISoundEventAccessor fromForge(final net.minecraft.client.audio.SoundEventAccessor accessor)
    {
        if (accessor instanceof ISoundEventAccessor)
        {
            return (ISoundEventAccessor) accessor;
        }

        return new SoundEventAccessor(accessor);
    }
}
