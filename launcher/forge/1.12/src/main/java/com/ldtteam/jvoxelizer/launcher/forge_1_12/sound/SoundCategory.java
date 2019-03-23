package com.ldtteam.jvoxelizer.launcher.forge_1_12.sound;

import com.ldtteam.jvoxelizer.sound.ISoundCategory;
import org.jetbrains.annotations.NotNull;

public class SoundCategory implements ISoundCategory
{
    private net.minecraft.util.SoundCategory forgeSoundCategory;

    private SoundCategory(@NotNull final net.minecraft.util.SoundCategory forgeSoundCategory)
    {
        this.forgeSoundCategory = forgeSoundCategory;
    }

    public static net.minecraft.util.SoundCategory asForge(final ISoundCategory soundCategory)
    {
        return ((SoundCategory) soundCategory).forgeSoundCategory;
    }

    public static ISoundCategory fromForge(final net.minecraft.util.SoundCategory soundCategory)
    {
        return new SoundCategory(soundCategory);
    }
}
