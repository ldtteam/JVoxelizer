package com.ldtteam.jvoxelizer.launcher.forge_1_12.sound;

import com.ldtteam.jvoxelizer.sound.ISound;
import com.ldtteam.jvoxelizer.sound.ISoundHandlerProvider;
import net.minecraft.client.audio.SoundHandler;

public class SoundHandlerProvider implements ISoundHandlerProvider
{
    private static SoundHandlerProvider ourInstance = new SoundHandlerProvider();

    public static SoundHandlerProvider getInstance()
    {
        return ourInstance;
    }

    private SoundHandlerProvider()
    {
    }

    @Override
    public ISound getMissingSound()
    {
        return Sound.fromForge(SoundHandler.MISSING_SOUND);
    }
}
