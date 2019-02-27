package com.ldtteam.jvoxelizer.launcher.forge_1_12.sound;

import com.ldtteam.jvoxelizer.sound.ISoundType;
import net.minecraft.client.audio.Sound;
import org.jetbrains.annotations.NotNull;

public class SoundType implements ISoundType
{
    private Sound.Type forgeSoundType;

    public SoundType(@NotNull final Sound.Type forgeType)
    {
        this.forgeSoundType = forgeSoundType;
    }
}
