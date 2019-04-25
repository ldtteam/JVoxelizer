package com.ldtteam.jvoxelizer.launcher.forge_1_13.sound;

import com.ldtteam.jvoxelizer.sound.ISoundType;
import net.minecraft.client.audio.Sound;
import org.jetbrains.annotations.NotNull;

public class SoundType implements ISoundType
{
    private Sound.Type forgeSoundType;

    private SoundType(@NotNull final Sound.Type forgeType)
    {
        this.forgeSoundType = forgeSoundType;
    }

    private Sound.Type getForgeSoundType()
    {
        return forgeSoundType;
    }

    public static Sound.Type asForge(final ISoundType type)
    {
        return ((SoundType) type).getForgeSoundType();
    }

    public static ISoundType fromForge(final Sound.Type type)
    {
        return new SoundType(type);
    }
}
