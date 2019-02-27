package com.ldtteam.jvoxelizer.launcher.forge_1_12.sound;

import com.ldtteam.jvoxelizer.sound.ISoundCategory;
import org.jetbrains.annotations.NotNull;

public class SoundCategory implements ISoundCategory
{
    net.minecraft.util.SoundCategory forgeSoundCategory;

    public SoundCategory(@NotNull final net.minecraft.util.SoundCategory forgeSoundCategory)
    {
        this.forgeSoundCategory = forgeSoundCategory;
    }

}
